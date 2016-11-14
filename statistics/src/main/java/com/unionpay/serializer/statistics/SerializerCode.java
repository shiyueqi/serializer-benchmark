package com.unionpay.serializer.statistics;

import com.unionpay.serializer.Constants;
/**
 * date: 2016/11/04 13:21.
 * author: Yueqi Shi
 */
public enum SerializerCode {

    JAVA_10000(Constants.SERIALIZER_JAVA, 10000, 1159, 467328811L, 1165444282L, 21398.209921194008, 8580.418776296334),

    JAVA_100000(Constants.SERIALIZER_JAVA, 100000, 1159, 1639105102L, 4585496501L, 61008.90045304734, 21807.889282696455),

    JAVA_1000000(Constants.SERIALIZER_JAVA, 1000000, 1159, 11711751940L, 36421263159L, 85384.32209997781, 27456.488689983602),

    JAVA_10000000(Constants.SERIALIZER_JAVA, 10000000, 1159, 108098091800L, 373911202387L, 92508.57099773522, 26744.31773148628),


    JSON_10000(Constants.SERIALIZER_JSON, 10000, 681, 422706207L, 645190457L, 23657.092880114724, 15499.29930225239),

    JSON_100000(Constants.SERIALIZER_JSON, 100000, 681, 841819448L, 1117093795L, 118790.31808730558, 89517.99790455375),

    JSON_1000000(Constants.SERIALIZER_JSON, 1000000, 681, 3978229016L, 5436625824L, 251368.13289986821, 183937.61725986312),

    JSON_10000000(Constants.SERIALIZER_JSON, 10000000, 681, 33579124567L, 48330811461L, 297804.0710992071, 206907.3474603129),


    PROTOBUF_10000(Constants.SERIALIZER_PROTOBUF, 10000, 368, 158859919L, 337934101L, 62948.540216742775, 29591.568209329664),

    PROTOBUF_100000(Constants.SERIALIZER_PROTOBUF, 100000, 368, 236283147L, 594380834L, 423221.0433527026, 168242.30237544974),

    PROTOBUF_1000000(Constants.SERIALIZER_PROTOBUF, 1000000, 368, 876653613L, 2562175015L, 1140701.3958202896, 390293.4007808206),

    PROTOBUF_10000000(Constants.SERIALIZER_PROTOBUF, 10000000, 368, 6563506360L, 23302476758L, 1523575.8833027168, 429138.93247707625),


    THRIFT_10000(Constants.SERIALIZER_THRIFT, 10000, 369, 339197919L, 343813527L, 29481.312944021924, 29085.533915016673),

    THRIFT_100000(Constants.SERIALIZER_THRIFT, 100000, 369, 1419039491L, 816852307L, 70470.20229826712, 122421.15146526726),

    THRIFT_1000000(Constants.SERIALIZER_THRIFT, 1000000, 369, 4955813534L, 3932493816L, 201783.21745549355, 254291.56326485117),

    THRIFT_10000000(Constants.SERIALIZER_THRIFT, 10000000, 369, 32164724314L, 39623337018L, 310899.6023835779, 252376.52233725853);

    /**
     * 序列化测试名称
     */
    private final String testName;

    /**
     * 循环次数
     */
    private final int callCount;

    /**
     * 序列化后byte[] 大小
     */
    private final int serializeBytesSize;

    /**
     * 序列化时间
     */
    private final long serializeTime;

    /**
     * 反序列化时间
     */
    private final long deserializeTime;

    /**
     * 序列化tps
     */
    private final double serializeTps;

    /**
     * 反序列化tps
     */
    private final double deserializeTps;

    private SerializerCode(String testName, int callCount, int serializeBytesSize
            , long serializeTime, long deserializeTime, double serializeTps, double deserializeTps) {
        this.testName = testName;
        this.callCount = callCount;
        this.serializeBytesSize = serializeBytesSize;
        this.serializeTime = serializeTime;
        this.deserializeTime = deserializeTime;
        this.serializeTps = serializeTps;
        this.deserializeTps = deserializeTps;
    }

    public String getTestName() {
        return testName;
    }

    public int getCallCount() {
        return callCount;
    }

    public int getSerializeBytesSize() {
        return serializeBytesSize;
    }

    public long getSerializeTime() {
        return serializeTime;
    }

    public long getDeserializeTime() {
        return deserializeTime;
    }

    public double getSerializeTps() {
        return serializeTps;
    }

    public double getDeserializeTps() {
        return deserializeTps;
    }


    public Number getStatistics(StatisticsType statisticsType) {
        if(statisticsType.getCode() == StatisticsType.SERIALIZE_TIME.getCode()) {
            return getSerializeTime();
        } else if (statisticsType.getCode() == StatisticsType.DESERIALIZE_TIME.getCode()) {
            return getDeserializeTime();
        } else if (statisticsType.getCode() == StatisticsType.SERIALIZE_BYTES_SIZE.getCode()) {
            return getSerializeBytesSize();
        } else if (statisticsType.getCode() == StatisticsType.SERIALIZE_TPS.getCode()) {
            return getSerializeTps();
        } else if (statisticsType.getCode() == StatisticsType.DESERIALIZE_TPS.getCode()) {
            return getDeserializeTps();
        } else {
            return 0;
        }
    }


}
