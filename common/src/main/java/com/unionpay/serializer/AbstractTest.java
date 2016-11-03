package com.unionpay.serializer;

import com.unionpay.serializer.util.BytesUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * date: 2016/10/28 19:05.
 * author: Yueqi Shi
 */
public abstract class AbstractTest implements Serializer{

    /**
     * 调用次数
     */
    private int callCount;

    /**
     * 待序列化对象
     */
    private Object user;

    public AbstractTest(String[] args, Object user) {
        if(args == null ) {
            throw new IllegalArgumentException("Input paramters must not be null");
        }

        callCount = Integer.parseInt(args[0]);
        this.user = user;
    }

    public int getCallCount() {
        return callCount;
    }



    @Override
    public int getSerializeSize(Object obj) {
        return this.serialize(1, obj).length;
    }

    @Override
    public void printSerializeBytesSize(Object obj) {
        System.out.println(this.getTestName() + " serialize bytes size is: " + this.getSerializeSize(obj));
    }

    @Override
    public void printSerializeBytesToString(Object obj) {
        BytesUtil.printBytesToString(this.serialize(1, obj), this.getTestName());
    }


    /**
     * 序列化和反序列化实现
     */
    public void exec() {
        this.printSerializeBytesSize(this.user);
        this.printSerializeBytesToString(this.user);

        long serializeStartTime = System.nanoTime();
        this.serialize(this.getCallCount(), this.user);
        long serializeEndTime = System.nanoTime();
        this.printSerializeTime(serializeStartTime, serializeEndTime);

        try {
            byte[] bytes = this.serialize(1, this.user);

            long deserializeStartTime = System.nanoTime();
            this.deserialize(this.getCallCount(), bytes);
            long deserializeEndTime = System.nanoTime();
            this.printDeserializeTime(deserializeStartTime, deserializeEndTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动
     */
    public void start() {

        long startTime = System.currentTimeMillis();

        this.exec();

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println(this.getTestName() + "----execute call count: " + callCount
                + ", total time: " + totalTime
                + "ms, startTime: "
                + startTime + ", endTime: " + endTime);
    }


    /**
     * 打印序列化时间及TPS
     * @param serializeStartTime
     * @param serializeEndTime
     */
    private void printSerializeTime(long serializeStartTime, long serializeEndTime) {
        System.out.println("serialize tps: " + this.getCallCount() * 1000000000 / (serializeEndTime - serializeStartTime)
                + ", startTime: " + serializeStartTime + ", endTime: " + serializeEndTime + ", total time: "
                + (serializeEndTime - serializeStartTime) + "ns");
    }

    /**
     * 打印反序列化时间及TPS
     * @param deserializeStartTime
     * @param deserializeEndTime
     */
    private void printDeserializeTime(long deserializeStartTime, long deserializeEndTime) {
        System.out.println("deserialize tps: " + this.getCallCount() * 1000000000 / (deserializeEndTime - deserializeStartTime)
                + ", startTime: " + deserializeStartTime + ", endTime: " + deserializeEndTime + ", total time: "
                + (deserializeEndTime - deserializeStartTime) + "ns");
    }

}
