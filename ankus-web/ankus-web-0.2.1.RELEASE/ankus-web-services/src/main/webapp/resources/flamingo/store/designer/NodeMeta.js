/*
 * Copyright (C) 2011  Flamingo Project (http://www.opencloudengine.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * NodeMeta Store
 *
 * @class
 * @extends Ext.data.Store
 * @author <a href="mailto:hrkenshin@gmail.com">Seungbaek Lee</a>
 */
Ext.define('Flamingo.store.designer.NodeMeta', {
    extend: 'Ext.data.Store',
    alias: 'store.nodeMeta',

    model: 'Flamingo.model.designer.NodeMeta',

    data: [
        {
            "type": "START",
            "identifier": "START",
            "name": "Start",
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": 0,
            "minNextNodeCounts": 1,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "END,IN,OUT",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": "END"
        },
        {
            "type": "END",
            "identifier": "END",
            "name": "End",
            "minPrevNodeCounts": 1,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": 0,
            "notAllowedPrevTypes": "START,IN,OUT",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "START",
            "notAllowedNextNodes": ""
        },
        /*		{
         "type"                 : "HADOOP",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/mapreduce.png",
         "identifier"           : "HADOOP_MR",
         "name"                 : MSG.DESIGNER_MR,
         "qualifierLabel"       : "mr",
         "description"          : "Apache Hadoop MapReduce",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 0,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 0,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedPrevNodes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "HADOOP",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_pig.png",
         "identifier"           : "HADOOP_PIG",
         "name"                 : MSG.DESIGNER_PIG,
         "qualifierLabel"       : "pig",
         "description"          : "Apache Pig Latin Script",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 1,
         "maxPrevNodeCounts"    : 1,
         "minNextNodeCounts"    : 1,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedPrevNodes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "HADOOP",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_hive.png",
         "identifier"           : "HADOOP_HIVE",
         "name"                 : "Apache Hive",
         "qualifierLabel"       : "hive",
         "description"          : "Apache Hive QL",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 1,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 1,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "HADOOP",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/java.png",
         "identifier"           : "HADOOP_JAVA",
         "name"                 : "Java",
         "qualifierLabel"       : "java",
         "description"          : "Java Application",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 1,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 1,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "OTHERS",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/shell.png",
         "identifier"           : "HADOOP_SHELL",
         "name"                 : MSG.DESIGNER_BASH,
         "qualifierLabel"       : "shell",
         "description"          : "Shell Script",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 1,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 1,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "OTHERS",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/python.png",
         "identifier"           : "HADOOP_PYTHON",
         "name"                 : MSG.DESIGNER_PYTHON,
         "qualifierLabel"       : "python",
         "description"          : "Python Application",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 1,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 1,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedNextNodes"  : ""
         },  */
        {
            "type": "STATISTICS",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/numeric_stats.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_NUMERIC_STATISTICS",
            "name": "Numeric Statistics (Distribution)",
            "qualifierLabel": "anumstat",
            "description": "Numeric Statistics (Distribution)",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "STATISTICS",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/norminal_stats.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_NOMINAL_STATISTICS",
            "name": "Nominal Statistics (Distribution)",
            "qualifierLabel": "nominal",
            "description": "Nominal Statistics (Distribution)",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "STATISTICS",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/cf_sum_stats.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_CERTAIN_FACTOR_SUM",
            "name": "Certainty Factor based Sum",
            "qualifierLabel": "acfs",
            "description": "Ceratinnty Factor based Sum 확신도 기반 합계",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "PREPROCESSING",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/normalization.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_NORMAL",
            "name": "Min/Max Normalization",
            "qualifierLabel": "anormal",
            "description": "데이터 전처리를 위한 데이터 정규화",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "CORRELATION",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/binary.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_CORR_BOOL",
            "name": "Boolean Similarity/Correlation",
            "qualifierLabel": "acorrb",
            "description": "Boolean Data Set 벡터 형식의 데이터 기반 유사/상관 분석",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "CORRELATION",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/numeric.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_CORR_NUMERIC",
            "name": "Numeric Similarity/Correlation",
            "qualifierLabel": "acorrn",
            "description": "Numeric Data Set 벡터 형식의 데이터 기반 유사/상관 분석",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "CORRELATION",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/string.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_CORR_STRING",
            "name": "String Similarity",
            "qualifierLabel": "acorrs",
            "description": "String Data Set 벡터 형식의 데이터 기반 유사/상관 분석",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "CLASSIFICATION",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/id3.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_ID3",
            "name": "ID3 Classification",
            "qualifierLabel": "aid3",
            "description": "ID3 based Classification",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },

        {
            "type": "CLUSTERING",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/kmeans.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_KMEANS",
            "name": "K-Means Clustering",
            "qualifierLabel": "akmeans",
            "description": "K-Means based Clustering",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "CLUSTERING",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/em.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_EM",
            "name": "EM Clustering",
            "qualifierLabel": "aem",
            "description": "EM based Clustering",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "RECOMMENDATION",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/cf_similarity.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_CF_SIM",
            "name": "CF based Similarity",
            "qualifierLabel": "acfsim",
            "description": "Collaborative Filtering based Similarity",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "RECOMMENDATION",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/content_similarity.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_CONTENT_SIM",
            "name": "Content based Similarity",
            "qualifierLabel": "aconsim",
            "description": "Content based Similarity",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "RECOMMENDATION",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/userbased.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_CF_USER_RECOMMEND",
            "name": "User Similarity based Recommendation",
            "qualifierLabel": "auserrec",
            "description": "Collaborative Filtering User based Recommendation",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "RECOMMENDATION",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/itembased.png",
            "jobType": "MAPREDUCE",
            "identifier": "ALG_ANKUS_CF_ITEM_RECOMMEND",
            "name": "Item Similarity based Recommendation",
            "qualifierLabel": "aitemrec",
            "description": "Collaborative Filtering Item based Recommendation",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 0,
            "maxPrevNodeCounts": -1,
            "minNextNodeCounts": 0,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        },
        {
            "type": "HADOOP",
            "icon": CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_pig.png",
            "identifier": "HADOOP_PIG",
            "name": MSG.DESIGNER_PIG,
            "qualifierLabel": "pig",
            "description": "Apache Pig Latin Script",
            "isCheckColumns": false,
            "fixedInputColumns": false,
            "fixedOutputColumns": false,
            "readOnlyOutputColumns": false,
            "ignoreInput": true,
            "ignoreOutput": true,
            "minPrevNodeCounts": 1,
            "maxPrevNodeCounts": 1,
            "minNextNodeCounts": 1,
            "maxNextNodeCounts": -1,
            "notAllowedPrevTypes": "",
            "notAllowedNextTypes": "",
            "notAllowedPrevNodes": "",
            "notAllowedNextNodes": ""
        }

        /*,
         {
         "type"                 : "ALG",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_giraph.png",
         "jobType"              : "MAPREDUCE",
         "identifier"           : "ALG_GIRAPH",
         "name"                 : "Giraph",
         "qualifierLabel"       : "giraph",
         "description"          : "분산 병렬 처리를 위한 알고리즘",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 0,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 0,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedPrevNodes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "ALG",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_mahout.png",
         "jobType"              : "MAPREDUCE",
         "identifier"           : "ALG_MAHOUT_CF_ITEM",
         "name"                 : "Item based CF",
         "qualifierLabel"       : "mcfitem",
         "description"          : "Item based Collaborative Filtering",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 0,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 0,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedPrevNodes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "ALG",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_mahout.png",
         "jobType"              : "MAPREDUCE",
         "identifier"           : "ALG_MAHOUT_KMEANS",
         "name"                 : "K-Means Clustering",
         "qualifierLabel"       : "mkmeans",
         "description"          : "군집화 알고리즘",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 0,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 0,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedPrevNodes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "ALG",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_mahout.png",
         "jobType"              : "MAPREDUCE",
         "identifier"           : "ALG_MAHOUT_MINHASH",
         "name"                 : "Minhash Clustering",
         "qualifierLabel"       : "mminhash",
         "description"          : "유사 사용자 및 아이템별 가중치",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 0,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 0,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedPrevNodes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "ALG",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_mahout.png",
         "jobType"              : "MAPREDUCE",
         "identifier"           : "ALG_MAHOUT_CANOPY",
         "name"                 : "Canopy Clustering",
         "qualifierLabel"       : "mcanopy",
         "description"          : "대용량 데이터의 효율적인 군집화 방법",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 0,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 0,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedPrevNodes"  : "",
         "notAllowedNextNodes"  : ""
         },
         {
         "type"                 : "ALG",
         "icon"                 : CONSTANTS.CONTEXT_PATH + "/resources/images/etl/apache_mahout.png",
         "jobType"              : "MAPREDUCE",
         "identifier"           : "ALG_MAHOUT_PARALLEL_FP_MINING",
         "name"                 : "Parallel FP Mining",
         "qualifierLabel"       : "mpfm",
         "description"          : "시퀀스 데이터의 빈번한 순차패턴을 위한 Mining",
         "isCheckColumns"       : false,
         "fixedInputColumns"    : false,
         "fixedOutputColumns"   : false,
         "readOnlyOutputColumns": false,
         "ignoreInput"          : true,
         "ignoreOutput"         : true,
         "minPrevNodeCounts"    : 0,
         "maxPrevNodeCounts"    : -1,
         "minNextNodeCounts"    : 0,
         "maxNextNodeCounts"    : -1,
         "notAllowedPrevTypes"  : "",
         "notAllowedNextTypes"  : "",
         "notAllowedPrevNodes"  : "",
         "notAllowedNextNodes"  : ""
         }*/
    ]
});