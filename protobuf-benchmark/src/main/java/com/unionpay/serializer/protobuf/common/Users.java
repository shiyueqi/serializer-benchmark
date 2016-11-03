package com.unionpay.serializer.protobuf.common;

import com.unionpay.serializer.Constants;
import com.unionpay.serializer.protobuf.user.User;
import com.unionpay.serializer.protobuf.user.UserAddress;
import com.unionpay.serializer.protobuf.user.UserOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * date: 2016/10/31 10:01.
 * author: Yueqi Shi
 */
public class Users {

    /**
     * get UserAddress obj
     * @return
     */
    public static UserAddress getUserAddress() {
        return UserAddress.newBuilder()
                .setId(Constants.userAddressId)
                .setAddress(Constants.userAddress)
                .setPhone(Constants.userAddressPhone)
                .build();
    }

    /**
     * get UserOrder obj
     * @return
     */
    public static UserOrder getUserOrder() {
        return UserOrder.newBuilder()
                .setId(Constants.userOrderId)
                .setGmtCreate(Constants.userOrderGmtCreate)
                .setMoney(Constants.userOrderMoney)
                .setLocation(Constants.userOrderLocation)
                .build();
    }

    /**
     * get UserOrder obj which id/gmtCreate/money arguments based on offset
     * @param offset
     * @return
     */
    public static UserOrder getUserOrder(int offset) {
        return UserOrder.newBuilder()
                .setId(Constants.userOrderId + offset)
                .setGmtCreate(Constants.userOrderGmtCreate + offset)
                .setMoney(Constants.userOrderMoney - offset)
                .setLocation(Constants.userOrderLocation)
                .build();
    }

    /**
     * get List<UserOrder>
     * @return
     */
    public static List<UserOrder> getUserOrders() {
        List<UserOrder> userOrders = new ArrayList<UserOrder>(3);

        for (int i = 0; i < Constants.userOrdersSize; i++) {
            userOrders.add(getUserOrder(10 * i));
        }

        return userOrders;
    }

    /**
     * get User obj
     * @return
     */
    public static User getUser() {
        return User.newBuilder()
                .setId(Constants.userId)
                .setUserName(Constants.userName)
                .addAllEverUsedName(Constants.everUsedNames)
                .setGender(Constants.gender)
                .setAge(Constants.age)
                .setPraiseCount(Constants.praiseCount)
                .addAllFanId(Constants.fanIds)
                .addAllFollowerId(Constants.followerIds)
                .addAllFanName(Constants.fanNames)
                .addAllFollowName(Constants.followNames)
                .addAllWeightId(Constants.weightIds)
                .setUserAddress(getUserAddress())
                .addAllUserOrder(getUserOrders())
                .build();
    }
}
