package com.unionpay.serializer.java.dto;

import java.io.Serializable;

/**
 * date: 2016/10/31 15:20.
 * author: Yueqi Shi
 */
public class UserOrder implements Serializable {

    private long id;

    private long gmtCreate;

    private int money;

    private String location;

    public UserOrder() {

    }

    public UserOrder(long id, long gmtCreate, int money, String location) {

        this.id = id;
        this.gmtCreate = gmtCreate;
        this.money = money;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", money=" + money +
                ", location='" + location + '\'' +
                '}';
    }
}
