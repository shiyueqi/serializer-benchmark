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
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            byte[] bytes = null;

            for (int i = 0; i < callCount; i++) {
                objectOutputStream.writeObject(obj);
                bytes = byteArrayOutputStream.toByteArray();
                System.out.println("call num " + i + ", bytes size is: " + bytes.length);
            }

            byteArrayOutputStream.close();
            objectOutputStream.close();

            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    public Object deserialize(int callCount, byte[] bytes) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            User user = null;

            for (int i = 0; i < callCount; i++) {
                user = (User)objectInputStream.readObject();
                System.out.println("call num " + i + ", user is: " + user);
            }

            byteArrayInputStream.close();
            objectInputStream.close();

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
