package com.unionpay.serializer;

import java.util.ArrayList;
import java.util.List;

/**
 * date: 2016/10/31 09:28.
 * author: Yueqi Shi
 */
public class Constants {

    /**
     * User POJO data
     */
    public static final long userId = 1L;

    public static final String userName = "userName";

    public static final List<String> everUsedNames = new ArrayList<String>();

    public static final int gender = 2;

    public static final int age = 26;

    public static final int praiseCount = -6;

    public static final List<Long> fanIds = new ArrayList<Long>();

    public static final List<Long> followerIds = new ArrayList<Long>();

    public static final List<String> fanNames = new ArrayList<String>();

    public static final List<String> followNames = new ArrayList<String>();

    public static final List<Long> weightIds = new ArrayList<Long>();


    /**
     * UserAddress POJO data
     */
    public static final long userAddressId = 2L;

    public static final String userAddress = "No. 1899 Gu Tong Road, Pudong New Area, Shanghai, China";

    public static final String userAddressPhone = "13012345678";


    /**
     * UserOrder POJO data
     */
    public static final long userOrderId = 3L;

    public static final long userOrderGmtCreate = 1477878398L;

    public static final int userOrderMoney = -10;

    public static final String userOrderLocation = "No. 1899 Gu Tong Road, Pudong New Area, Shanghai, China";

    public static final int userOrdersSize = 2;

    static {

        for (int i = 0; i < 3; i++) {
            everUsedNames.add("everUsedName" + i);
        }


        for (int i = 0; i < 3; i++) {
            fanIds.add(10000L + i);
        }


        for (int i = 0; i < 3; i++) {
            followerIds.add(20000L + i);
        }


        for (int i = 0; i < 3; i++) {
            fanNames.add("fanName" + i);
        }


        for (int i = 0; i < 3; i++) {
            followNames.add("followName" + i);
        }

        for (int i = 0; i < 3; i++) {
            weightIds.add(-1L * i);
        }
    }

}
