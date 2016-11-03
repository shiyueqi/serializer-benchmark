package com.unionpay.serializer.java;

import com.unionpay.serializer.AbstractTest;
import com.unionpay.serializer.Serializer;
import com.unionpay.serializer.java.common.Users;
import com.unionpay.serializer.java.dto.User;

import java.io.*;

/**
 * date: 2016/10/31 16:48.
 * author: Yueqi Shi
 */
public class JavaTest extends AbstractTest implements Serializer{

    public JavaTest(String[] args, User user) {
        super(args, user);
    }

    public String getTestName() {
        return "java";
    }

    public byte[] serialize(int callCount, Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = null;
            ObjectOutputStream objectOutputStream = null;
            byte[] bytes = null;

            for (int i = 0; i < callCount; i++) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

                objectOutputStream.writeObject(obj);
                bytes = byteArrayOutputStream.toByteArray();

                byteArrayOutputStream.close();
                objectOutputStream.close();

                //System.out.println("call num " + i + ", bytes size is: " + bytes.length);
            }

            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    public Object deserialize(int callCount, byte[] bytes) {
        try {
            ByteArrayInputStream byteArrayInputStream = null;
            ObjectInputStream objectInputStream = null;
            User user = null;

            for (int i = 0; i < callCount; i++) {
                byteArrayInputStream = new ByteArrayInputStream(bytes);
                objectInputStream = new ObjectInputStream(byteArrayInputStream);

                user = (User)objectInputStream.readObject();

                byteArrayInputStream.close();
                objectInputStream.close();

                //System.out.println("call num " + i + ", user is: " + user);
            }

            return user;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new User();
    }


    public static void main(String[] args) {
        new JavaTest(args, Users.getUser()).start();
    }

}
