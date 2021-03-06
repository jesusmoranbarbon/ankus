/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ankus.mapreduce.algorithms.classification.id3;

import org.ankus.mapreduce.algorithms.classification.confusionMatrix.ConfusionMatrixMapper;
import org.ankus.mapreduce.algorithms.classification.confusionMatrix.ConfusionMatrixReducer;
import org.ankus.mapreduce.algorithms.classification.confusionMatrix.ValidationMain;
import org.ankus.mapreduce.algorithms.classification.rulestructure.RuleMgr;
import org.ankus.util.ArgumentsConstants;
import org.ankus.util.ConfigurationVariable;
import org.ankus.util.Constants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ID3Driver
 * @desc
 *
 * @version 0.1
 * @date : 2013.11.12
 * @author Moonie Song
 */
public class ID3Driver extends Configured implements Tool {

    private Logger logger = LoggerFactory.getLogger(ID3Driver.class);
    private String m_minData = "5";
    private String m_purity = "0.75";

    public int run(String[] args) throws Exception
    {
        Configuration conf = this.getConf();
        if(!ConfigurationVariable.setFromArguments(args, conf))
        {
            logger.info("> MR Job Setting Failed..");
            return 1;
        }

        /*

        if, train - model generation
            temp delete check

        test (model or final-result-gen)
            classify
            if class index exist > validation
            else no validation

            if(final-result-gen) train classify result remove


         */

        boolean isOnlyTest = false;
        boolean isTrained = false;
        boolean isTrainResultGen = false;
        boolean isValidation = false;
        if(conf.get(ArgumentsConstants.TRAINED_MODEL, null) != null) isOnlyTest = true;

        int iterCnt = 0;
        String outputBase = conf.get(ArgumentsConstants.OUTPUT_PATH, null);
        String ruleFilePath = outputBase + "/id3_rule";
        String delimiter = conf.get(ArgumentsConstants.DELIMITER, "\t");

        // training process
        if(!isOnlyTest)
        {
            if(!conf.get(ArgumentsConstants.NUMERIC_INDEX, "-1").equals("-1"))
            {
                logger.info("> ID3(Ankus) is not support Numeric Attribute.");
                logger.info("> Only Support Nominal Attribute.");
                return 1;
            }

            if(conf.get(ArgumentsConstants.CLASS_INDEX, "-1").equals("-1"))
            {
                logger.info("> Class Index is must defined for Training in ID3(Ankus).");
                return 1;
            }

            conf.set(ArgumentsConstants.MIN_LEAF_DATA, conf.get(ArgumentsConstants.MIN_LEAF_DATA, m_minData));
            conf.set(ArgumentsConstants.PURITY, conf.get(ArgumentsConstants.PURITY, m_purity));
            conf.set(ArgumentsConstants.DELIMITER, delimiter);

            logger.info("Purity for Pruning: " + conf.get(ArgumentsConstants.PURITY));
            logger.info("Minimum Lef Node Count for Pruning: " + conf.get(ArgumentsConstants.MIN_LEAF_DATA));
            logger.info("> ID3 Classification Iterations (Training) are Started..");
            logger.info("> : Information Gain Computation and Rule Update for Every Tree Node");

            String nodeStr;
            RuleMgr id3RuleMgr = new RuleMgr();
            while((nodeStr = id3RuleMgr.loadNonLeafNode(conf))!=null)
            {
                /**
                 << depth first process >>

                 load rule file newly
                 search non-leaf node
                 if(no non-leaf node) break;

                 MR - compute IG for appropriate non-leaf node

                 update rules using MR result and checked rule
                 : previous - update rule - next
                 */

                String tokens[] = nodeStr.split(conf.get(ArgumentsConstants.DELIMITER));
                conf.set(Constants.ID3_RULE_CONDITION, tokens[0]);
                conf.set(ArgumentsConstants.OUTPUT_PATH, outputBase + "/entropy_" + iterCnt);

                if(!computeAttributeEntropy(conf)) return 1;

                String oldRulePath = conf.get(ArgumentsConstants.RULE_PATH);
                conf.set(ArgumentsConstants.RULE_PATH, ruleFilePath + "_" + iterCnt);
                id3RuleMgr.updateRule(conf, oldRulePath, nodeStr);

                iterCnt++;
            }

            FileSystem.get(conf).rename(new Path(ruleFilePath + "_" + (iterCnt-1)), new Path(ruleFilePath));
            logger.info("> ID3 Classification Iterations are Finished..");

            isTrained = true;
            if(conf.get(ArgumentsConstants.FINAL_RESULT_GENERATION, "false").equals("true"))
                isTrainResultGen = true;
        }

        // test process | final result gen in training
        if(isOnlyTest || isTrainResultGen)
        {
            if(isOnlyTest) ruleFilePath = conf.get(ArgumentsConstants.TRAINED_MODEL);

            conf.set(ArgumentsConstants.OUTPUT_PATH, outputBase + "/classifying_result");
            conf.set(ArgumentsConstants.RULE_PATH, ruleFilePath);
            if(!finalClassifying(conf)) return 1;

            if(!conf.get(ArgumentsConstants.CLASS_INDEX, "-1").equals("-1"))
            {
                // class index exist
                conf.set(ArgumentsConstants.INPUT_PATH, conf.get(ArgumentsConstants.OUTPUT_PATH));
                conf.set(ArgumentsConstants.OUTPUT_PATH, outputBase + "/validation_tmp");
                if(!confusionMatrixGen(conf)) return 1;

                ValidationMain validate = new ValidationMain();
                FileSystem fs = FileSystem.get(conf);
                validate.validationGeneration(fs,
                        conf.get(ArgumentsConstants.OUTPUT_PATH),
                        conf.get(ArgumentsConstants.DELIMITER, "\t"),
                        outputBase + "/validation");

                isValidation = true;
            }
            logger.info("> ID3(Ankus) Classification Using Trained Model is Finished..");
        }

        // temp delete process
        if(conf.get(ArgumentsConstants.TEMP_DELETE, "true").equals("true"))
        {
            if(isTrained)
            {
                for(int i=0; i<iterCnt-1; i++)
                {
                    FileSystem.get(conf).delete(new Path(outputBase + "/entropy_" + i), true);
                    FileSystem.get(conf).delete(new Path(ruleFilePath + "_" + i), true);
                }
                FileSystem.get(conf).delete(new Path(outputBase + "/entropy_" + (iterCnt-1)), true);
            }

            if(isTrainResultGen) FileSystem.get(conf).delete(new Path(outputBase + "/classifying_result"), true);
            if(isValidation) FileSystem.get(conf).delete(new Path(outputBase + "/validation_tmp"), true);
            logger.info("> Temporary Files are Deleted..");
        }

        return 0;
    }


    /**
     * row data generation for confusion matrix (org-class, pred-class, frequency)
     * @param conf
     * @return
     * @throws Exception
     */
    private boolean confusionMatrixGen(Configuration conf) throws Exception
    {
        Job job = new Job(this.getConf());

        FileInputFormat.addInputPaths(job, conf.get(ArgumentsConstants.INPUT_PATH));
        FileOutputFormat.setOutputPath(job, new Path(conf.get(ArgumentsConstants.OUTPUT_PATH)));

        job.getConfiguration().set(ArgumentsConstants.DELIMITER, conf.get(ArgumentsConstants.DELIMITER, "\t"));
        job.getConfiguration().set(ArgumentsConstants.CLASS_INDEX, conf.get(ArgumentsConstants.CLASS_INDEX));

        job.setJarByClass(ID3Driver.class);

        job.setMapperClass(ConfusionMatrixMapper.class);
        job.setReducerClass(ConfusionMatrixReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        if(!job.waitForCompletion(true))
        {
            logger.info("Error: ID3(Rutine) Final Validation Check is not Completeion");
            return false;
        }

        return true;
    }

    /**
     * classification result generation for train file (add class info to train data file)
     * @param conf
     * @return
     * @throws Exception
     */
    private boolean finalClassifying(Configuration conf) throws Exception
    {
        Job job = new Job(this.getConf());

        FileInputFormat.addInputPaths(job, conf.get(ArgumentsConstants.INPUT_PATH));
        FileOutputFormat.setOutputPath(job, new Path(conf.get(ArgumentsConstants.OUTPUT_PATH)));

        job.getConfiguration().set(ArgumentsConstants.DELIMITER, conf.get(ArgumentsConstants.DELIMITER, "\t"));
        job.getConfiguration().set(ArgumentsConstants.RULE_PATH, conf.get(ArgumentsConstants.RULE_PATH));

        job.setJarByClass(ID3Driver.class);

        job.setMapperClass(ID3FinalClassifyingMapper.class);

        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setNumReduceTasks(0);

        if(!job.waitForCompletion(true))
        {
            logger.info("Error: ID3(Rutine) Final Mapper is not Completeion");
            return false;
        }

        return true;
    }







    private boolean computeAttributeEntropy(Configuration conf) throws Exception
    {
        Job job = new Job(this.getConf());

        FileInputFormat.addInputPaths(job, conf.get(ArgumentsConstants.INPUT_PATH));
        FileOutputFormat.setOutputPath(job, new Path(conf.get(ArgumentsConstants.OUTPUT_PATH)));

        job.getConfiguration().set(ArgumentsConstants.DELIMITER, conf.get(ArgumentsConstants.DELIMITER, "\t"));
        job.getConfiguration().set(ArgumentsConstants.TARGET_INDEX, conf.get(ArgumentsConstants.TARGET_INDEX, "-1"));
        job.getConfiguration().set(ArgumentsConstants.NUMERIC_INDEX, conf.get(ArgumentsConstants.NUMERIC_INDEX, "-1"));
        job.getConfiguration().set(ArgumentsConstants.EXCEPTION_INDEX, conf.get(ArgumentsConstants.EXCEPTION_INDEX, "-1"));
        job.getConfiguration().set(ArgumentsConstants.CLASS_INDEX, conf.get(ArgumentsConstants.CLASS_INDEX, "-1"));
        job.getConfiguration().set(ArgumentsConstants.MIN_LEAF_DATA, conf.get(ArgumentsConstants.MIN_LEAF_DATA, "1"));
        job.getConfiguration().set(ArgumentsConstants.PURITY, conf.get(ArgumentsConstants.PURITY, "1"));
        job.getConfiguration().set(Constants.ID3_RULE_CONDITION, conf.get(Constants.ID3_RULE_CONDITION, "root"));

        job.setJarByClass(ID3Driver.class);
        job.setMapperClass(ID3AttributeSplitMapper.class);
        job.setReducerClass(ID3ComputeEntropyReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        if(!job.waitForCompletion(true))
        {
            logger.info("Error: 1-MR for ID3(Rutine) is not Completeion");
            return false;
        }

        return true;
    }


    public static void main(String args[]) throws Exception
    {
        int res = ToolRunner.run(new ID3Driver(), args);
        System.exit(res);
    }
}
