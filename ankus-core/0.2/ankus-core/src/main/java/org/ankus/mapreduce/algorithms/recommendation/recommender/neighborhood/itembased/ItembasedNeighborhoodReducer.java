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
package org.ankus.mapreduce.algorithms.recommendation.recommender.neighborhood.itembased;

import org.ankus.util.Constants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ItembasedNeighborhoodReducer
 * @desc
 *      Join multi input format files.
 *      User-based Collaborative Filtering recommendation algorithms
 * @version 0.0.1
 * @date : 2013.07.30
 * @author Suhyun Jeon
 */
public class ItembasedNeighborhoodReducer extends Reducer<Text, Text, Text, Text> {

    private String delimiter;

	@Override
    protected void setup(Context context) throws IOException, InterruptedException {
        Configuration configuration = context.getConfiguration();
        this.delimiter = configuration.get(Constants.DELIMITER);
    }  

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
    	Iterator<Text> iterator = values.iterator();

        List<String> neighborhoodItemList = new ArrayList<String>();
        List<String> userList = new ArrayList<String>();
        List<String> ratingList = new ArrayList<String>();

        while (iterator.hasNext()){
            Text record = iterator.next();
            String[] columns = record.toString().split("\t");

            if(columns[1].equals(Constants.SIMILARITY)){
                neighborhoodItemList.add(columns[0]);
            }else{
                userList.add(columns[0]);
                ratingList.add(columns[2]);
            }
        }

        Text text = null;
        if(userList.size() > 0 ){
            for(int i=0; i<neighborhoodItemList.size(); i++) {
                for(int k=0; k<userList.size(); k++){
                    text = new Text(key.toString() + this.delimiter + userList.get(k) + this.delimiter + ratingList.get(k));
                    context.write(new Text(neighborhoodItemList.get(i)), text);
                }
            }
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
    }
}