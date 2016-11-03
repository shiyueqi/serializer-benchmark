package com.unionpay.serializer.util;

/**
 * date: 2016/10/31 14:19.
 * author: Yueqi Shi
 */
public class BytesUtil {
    /**
     * 将序列化后的 byte[] 打印成 16 进制字符串
     * @param bytes
     */
    public static void printBytesToString(byte[] bytes, String structName) {
        System.out.println("*************" + structName + "**************");

        StringBuilder stringBuilder = new StringBuilder();

        for (Byte byteStr : bytes) {
            String hexByteStr = Integer.toHexString(byteStr.intValue());


            if (hexByteStr.length() < 2) {
                stringBuilder.append("0");
            }

            if (hexByteStr.length() > 2) {
                hexByteStr = hexByteStr.substring(hexByteStr.length()-2, hexByteStr.length());
            }

            stringBuilder.append(hexByteStr);
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString());
        System.out.println("************************************");
    }
}
