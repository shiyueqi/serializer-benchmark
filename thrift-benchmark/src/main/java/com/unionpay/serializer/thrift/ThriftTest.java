package com.unionpay.serializer.thrift;

import com.unionpay.serializer.AbstractTest;
import com.unionpay.serializer.Serializer;
import com.unionpay.serializer.thrift.common.Users;
import com.unionpay.serializer.thrift.dto.User;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * date: 2016/11/02 19:05.
 * author: Yueqi Shi
 */
public class ThriftTest extends AbstractTest implements Serializer{

    public ThriftTest(String[] args, Object user) {
        super(args, user);
    }

    @Override
    public String getTestName() {
        return "thrift";
    }

    @Override
    public byte[] serialize(int callCount, Object obj) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            TTransport trans = new TIOStreamTransport(out);
            TBinaryProtocol tp = new TBinaryProtocol(trans);
            byte[] bytes = null;

            for (int i = 0; i < callCount; i++) {
                ((User)obj).write(tp);
                bytes = out.toByteArray();
                System.out.println("call num " + i + ", bytes size is: " + bytes.length);
            }

            return bytes;
        } catch (TException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    @Override
    public Object deserialize(int callCount, byte[] bytes) {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            TTransport trans = new TIOStreamTransport(in);
            TBinaryProtocol tp = new TBinaryProtocol(trans);
            User user = new User();

            for (int i = 0; i < callCount; i++) {
                user.read(tp);
                System.out.println("call num " + i + ", user is: " + user);
            }

            return user;
        } catch (TException e) {
            e.printStackTrace();
        }

        return new User();
    }

    public static void main(String[] args) {
        new ThriftTest(args, Users.getUser()).start();
    }
}
