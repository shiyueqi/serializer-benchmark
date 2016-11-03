package com.unionpay.serializer.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unionpay.serializer.AbstractTest;
import com.unionpay.serializer.Serializer;
import com.unionpay.serializer.json.common.Users;
import com.unionpay.serializer.json.dto.User;

/**
 * date: 2016/10/31 14:43.
 * author: Yueqi Shi
 */
public class JsonTest extends AbstractTest implements Serializer {

    public JsonTest(String[] args, User user) {
        super(args, user);
    }

    @Override
    public String getTestName() {
        return "fastjson";
    }

    @Override
    public byte[] serialize(int callCount, Object obj) {
        byte[] bytes = null;
        for (int i = 0; i < callCount; i++) {
            bytes = JSONObject.toJSONBytes(obj);
        }

        return bytes;
    }

    @Override
    public Object deserialize(int callCount, byte[] bytes) {
        User user = null;
        for (int i = 0; i < callCount; i++) {
            user = (User)JSON.parse(bytes);
        }

        return user;
    }


    public static void main(String[] args) {
        new JsonTest(args, Users.getUser()).start();
    }

}
