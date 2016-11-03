package com.unionpay.serializer.thrift.common;

import com.unionpay.serializer.Constants;
import com.unionpay.serializer.thrift.dto.User;
import com.unionpay.serializer.thrift.dto.UserAddress;
import com.unionpay.serializer.thrift.dto.UserOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * date: 2016/11/03 11:17.
 * author: Yueqi Shi
 */
public class Users {
    /**
     * get UserAddress obj
     * @return
     */
    public static UserAddress getUserAddress() {
        return new UserAddress(Constants.userAddressId
                , Constants.userAddress
                , Constants.userAddressPhone);

    }

    /**
     * get UserOrder obj
     * @return
     */
    public static UserOrder getUserOrder() {
        return new UserOrder(Constants.userOrderId
                , Constants.userOrderGmtCreate
                , Constants.userOrderMoney
                , Constants.userOrderLocation);
    }

    /**
     * get UserOrder obj which id/gmtCreate/money arguments based on offset
     * @param offset
     * @return
     */
    public static UserOrder getUserOrder(int offset) {
        return new UserOrder(Constants.userOrderId + offset
                , Constants.userOrderGmtCreate + offset
                , Constants.userOrderMoney - offset
                , Constants.userOrderLocation);
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
        return new User(Constants.userId
                , Constants.userName
                , Constants.everUsedNames
                , Constants.gender
                , Constants.age
                , Constants.praiseCount
                , Constants.fanIds
                , Constants.followerIds
                , Constants.fanNames
                , Constants.followNames
                , Constants.weightIds
                , getUserAddress()
                , getUserOrders());
    }
}
