package com.unionpay.serializer;

/**
 * date: 2016/10/31 16:36.
 * author: Yueqi Shi
 */
public interface Serializer {
    /**
     * get test name
     * @return
     */
    String getTestName();

    /**
     * serialize from obj to byte[]
     * @param callCount 循环次数
     * @param obj 序列化对象
     * @return
     */
    byte[] serialize(int callCount, Object obj);

    /**
     * deserialize from byte[] to obj
     * @param callCount 循环次数
     * @param bytes 反序列化byte[]
     * @return
     */
    Object deserialize(int callCount, byte[] bytes);

    /**
     * get serialize bytes size
     * @param obj 待序列化对象
     * @return
     */
    int getSerializeSize(Object obj);

    /**
     * 打印序列化后的byte[] 大小
     * @param obj
     */
    void printSerializeBytesSize(Object obj);

    /**
     * 打印序列化后的byte[] 16进制字符串
     * @param obj
     */
    void printSerializeBytesToString(Object obj);

}
