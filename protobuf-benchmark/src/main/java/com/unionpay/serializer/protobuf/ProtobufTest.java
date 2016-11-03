package com.unionpay.serializer.protobuf;


import com.google.protobuf.InvalidProtocolBufferException;
import com.unionpay.serializer.AbstractTest;
import com.unionpay.serializer.Serializer;
import com.unionpay.serializer.protobuf.common.Users;
import com.unionpay.serializer.protobuf.user.User;
import com.unionpay.serializer.util.BytesUtil;

import java.io.*;

/**
 * date: 2016/10/28 18:16.
 * author: Yueqi Shi
 */
public class ProtobufTest extends AbstractTest implements Serializer {

    public ProtobufTest(String[] args, User user) {
        super(args, user);
    }

    @Override
    public String getTestName() {
        return "protobuf";
    }

    @Override
    public byte[] serialize(int callCount, Object obj) {
        byte[] bytes = null;
        for (int i = 0; i < callCount; i++) {
            bytes = ((User)obj).toByteArray();
        }

        return bytes;
    }

    @Override
    public Object deserialize(int callCount, byte[] bytes) {
        try {
            User user = null;
            for (int i = 0; i < callCount; i++) {
                user = User.parseFrom(bytes);
            }

            return user;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        return User.newBuilder().build();
    }


    public static void main(String[] args) {
        new ProtobufTest(args, Users.getUser()).start();
    }


}
