package com.unionpay.serializer.statistics;

/**
 * date: 2016/11/04 17:06.
 * author: Yueqi Shi
 */
public enum StatisticsType {

    SERIALIZE_TIME(1, "protobuf/thrift/fastjson/java 序列化时间对比", "运行次数", "时间(ns)"),

    DESERIALIZE_TIME(2, "protobuf/thrift/fastjson/java 反序列化时间对比", "运行次数", "时间(ns)"),

    SERIALIZE_BYTES_SIZE(3, "protobuf/thrift/fastjson/java 序列化字节数对比", "运行次数", "字节数(byte)"),

    SERIALIZE_TPS(4, "protobuf/thrift/fastjson/java 序列化TPS对比", "运行次数", "TPS"),

    DESERIALIZE_TPS(5, "protobuf/thrift/fastjson/java 反序列化TPS对比", "运行次数", "TPS");

    /**
     * 统计类型code
     */
    private int code;

    /**
     * 统计类型描述
     */
    private String description;

    /**
     * 统计类型目录轴描述
     */
    private String categoryAxisLabel;

    /**
     * 统计类型数值轴描述
     */
    private String valueAxisLabel;

    private StatisticsType(int code, String description, String categoryAxisLabel, String valueAxisLabel) {
        this.code = code;
        this.description = description;
        this.categoryAxisLabel = categoryAxisLabel;
        this.valueAxisLabel = valueAxisLabel;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getCategoryAxisLabel() {
        return this.categoryAxisLabel;
    }

    public String getValueAxisLabel() {
        return this.valueAxisLabel;
    }
}
