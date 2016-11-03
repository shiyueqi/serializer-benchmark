package com.unionpay.serializer.json.dto;

import java.io.Serializable;
import java.util.List;

/**
 * date: 2016/10/31 15:19.
 * author: Yueqi Shi
 */
public class User implements Serializable{

    private long userId;

    private String userName;

    private List<String> everUsedNames;

    private int gender;

    private int age;

    private int praiseCount;

    private List<Long> fanIds;

    private List<Long> followerIds;

    private List<String> fanNames;

    private List<String> followNames;

    private List<Long> weightIds;

    private UserAddress userAddress;

    private List<UserOrder> userOrders;

    public User() {
    }

    public User(long userId, String userName, List<String> everUsedNames
            , int gender, int age, int praiseCount, List<Long> fanIds
            , List<Long> followerIds, List<String> fanNames, List<String> followNames
            , List<Long> weightIds, UserAddress userAddress, List<UserOrder> userOrders) {
        this.userId = userId;
        this.userName = userName;
        this.everUsedNames = everUsedNames;
        this.gender = gender;
        this.age = age;
        this.praiseCount = praiseCount;
        this.fanIds = fanIds;
        this.followerIds = followerIds;
        this.fanNames = fanNames;
        this.followNames = followNames;
        this.weightIds = weightIds;
        this.userAddress = userAddress;
        this.userOrders = userOrders;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getEverUsedNames() {
        return everUsedNames;
    }

    public void setEverUsedNames(List<String> everUsedNames) {
        this.everUsedNames = everUsedNames;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public List<Long> getFanIds() {
        return fanIds;
    }

    public void setFanIds(List<Long> fanIds) {
        this.fanIds = fanIds;
    }

    public List<Long> getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(List<Long> followerIds) {
        this.followerIds = followerIds;
    }

    public List<String> getFanNames() {
        return fanNames;
    }

    public void setFanNames(List<String> fanNames) {
        this.fanNames = fanNames;
    }

    public List<String> getFollowNames() {
        return followNames;
    }

    public void setFollowNames(List<String> followNames) {
        this.followNames = followNames;
    }

    public List<Long> getWeightIds() {
        return weightIds;
    }

    public void setWeightIds(List<Long> weightIds) {
        this.weightIds = weightIds;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }

    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", everUsedNames=" + everUsedNames +
                ", gender=" + gender +
                ", age=" + age +
                ", praiseCount=" + praiseCount +
                ", fanIds=" + fanIds +
                ", followerIds=" + followerIds +
                ", fanNames=" + fanNames +
                ", followNames=" + followNames +
                ", weightIds=" + weightIds +
                ", userAddress=" + userAddress +
                ", userOrders=" + userOrders +
                '}';
    }
}
