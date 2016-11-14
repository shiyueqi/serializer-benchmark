package com.unionpay.serializer.statistics;

import com.unionpay.serializer.Constants;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * date: 2016/11/04 16:16.
 * author: Yueqi Shi
 */
public class DataService {
    private static final String CALL_COUNT_10000_STR      =    "10000次调用";
    private static final String CALL_COUNT_100000_STR     =    "100000次调用";
    private static final String CALL_COUNT_1000000_STR    =    "1000000次调用";
    private static final String CALL_COUNT_10000000_STR   =    "10000000次调用";


    /**
     * 获取序列化各项性能测试的统计数据集合
     * @param statisticsType 统计类型
     * @return 统计数据集合
     */
    public static CategoryDataset getStatisticsDataSet(StatisticsType statisticsType) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        dataSet.setValue(SerializerCode.PROTOBUF_10000.getStatistics(statisticsType), Constants.SERIALIZER_PROTOBUF, CALL_COUNT_10000_STR);
        dataSet.setValue(SerializerCode.THRIFT_10000.getStatistics(statisticsType), Constants.SERIALIZER_THRIFT, CALL_COUNT_10000_STR);
        dataSet.setValue(SerializerCode.JSON_10000.getStatistics(statisticsType), Constants.SERIALIZER_JSON, CALL_COUNT_10000_STR);
        dataSet.setValue(SerializerCode.JAVA_10000.getStatistics(statisticsType), Constants.SERIALIZER_JAVA, CALL_COUNT_10000_STR);

        dataSet.setValue(SerializerCode.PROTOBUF_100000.getStatistics(statisticsType), Constants.SERIALIZER_PROTOBUF, CALL_COUNT_100000_STR);
        dataSet.setValue(SerializerCode.THRIFT_100000.getStatistics(statisticsType), Constants.SERIALIZER_THRIFT, CALL_COUNT_100000_STR);
        dataSet.setValue(SerializerCode.JSON_100000.getStatistics(statisticsType), Constants.SERIALIZER_JSON, CALL_COUNT_100000_STR);
        dataSet.setValue(SerializerCode.JAVA_100000.getStatistics(statisticsType), Constants.SERIALIZER_JAVA, CALL_COUNT_100000_STR);

        dataSet.setValue(SerializerCode.PROTOBUF_1000000.getStatistics(statisticsType), Constants.SERIALIZER_PROTOBUF, CALL_COUNT_1000000_STR);
        dataSet.setValue(SerializerCode.THRIFT_1000000.getStatistics(statisticsType), Constants.SERIALIZER_THRIFT, CALL_COUNT_1000000_STR);
        dataSet.setValue(SerializerCode.JSON_1000000.getStatistics(statisticsType), Constants.SERIALIZER_JSON, CALL_COUNT_1000000_STR);
        dataSet.setValue(SerializerCode.JAVA_1000000.getStatistics(statisticsType), Constants.SERIALIZER_JAVA, CALL_COUNT_1000000_STR);

        dataSet.setValue(SerializerCode.PROTOBUF_10000000.getStatistics(statisticsType), Constants.SERIALIZER_PROTOBUF, CALL_COUNT_10000000_STR);
        dataSet.setValue(SerializerCode.THRIFT_10000000.getStatistics(statisticsType), Constants.SERIALIZER_THRIFT, CALL_COUNT_10000000_STR);
        dataSet.setValue(SerializerCode.JSON_10000000.getStatistics(statisticsType), Constants.SERIALIZER_JSON, CALL_COUNT_10000000_STR);
        dataSet.setValue(SerializerCode.JAVA_10000000.getStatistics(statisticsType), Constants.SERIALIZER_JAVA, CALL_COUNT_10000000_STR);

        return dataSet;
    }
}
