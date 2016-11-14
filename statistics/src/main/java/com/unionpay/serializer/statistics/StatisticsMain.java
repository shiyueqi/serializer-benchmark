package com.unionpay.serializer.statistics;

/**
 * date: 2016/11/04 16:48.
 * author: Yueqi Shi
 */
public class StatisticsMain {

    public static void main(String[] args) {
        /**
         * 序列化时间统计
         */
        StatisticsBarChart.makeStatisticsBarChart3D(StatisticsType.SERIALIZE_TIME);

        /**
         * 反序列化时间统计
         */
        StatisticsBarChart.makeStatisticsBarChart3D(StatisticsType.DESERIALIZE_TIME);

        /**
         * 序列化字节大小统计
         */
        StatisticsBarChart.makeStatisticsBarChart3D(StatisticsType.SERIALIZE_BYTES_SIZE);

        /**
         * 序列化TPS统计
         */
        StatisticsBarChart.makeStatisticsBarChart3D(StatisticsType.SERIALIZE_TPS);

        /**
         * 反序列化TPS统计
         */
        StatisticsBarChart.makeStatisticsBarChart3D(StatisticsType.DESERIALIZE_TPS);
    }
}
