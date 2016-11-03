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
            ByteArrayOutputStream byteArrayOutputStream = null;
            TTransport tTransport = null;
            TCompactProtocol tProtocol = null;
            byte[] bytes = null;

            for (int i = 0; i < callCount; i++) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                tTransport = new TIOStreamTransport(byteArrayOutputStream);
                tProtocol = new TCompactProtocol(tTransport);

                ((User)obj).write(tProtocol);
                bytes = byteArrayOutputStream.toByteArray();

                byteArrayOutputStream.close();
                tTransport.close();

                //System.out.println("call num " + i + ", bytes size is: " + bytes.length);
            }

            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

        return new byte[0];
    }

    @Override
    public Object deserialize(int callCount, byte[] bytes) {
        try {
            ByteArrayInputStream byteArrayInputStream = null;
            TTransport tTransport = null;
            TCompactProtocol tProtocol = null;
            User user = new User();

            for (int i = 0; i < callCount; i++) {
                byteArrayInputStream = new ByteArrayInputStream(bytes);
                tTransport = new TIOStreamTransport(byteArrayInputStream);
                tProtocol = new TCompactProtocol(tTransport);

                user.read(tProtocol);

                byteArrayInputStream.close();
                tTransport.close();

                //System.out.println("call num " + i + ", user is: " + user.toString());
            }

            return user;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

        return new User();
    }

    public static void main(String[] args) {
        new ThriftTest(args, Users.getUser()).start();
    }
}
