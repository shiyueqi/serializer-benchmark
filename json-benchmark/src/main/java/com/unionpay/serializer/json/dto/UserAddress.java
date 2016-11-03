package com.unionpay.serializer.json.dto;

import java.io.Serializable;

/**
 * date: 2016/10/31 15:19.
 * author: Yueqi Shi
 */
public class UserAddress implements Serializable {

    private long id;

    private String address;

    private String phone;

    public UserAddress() {

    }

    public UserAddress(long id, String address, String phone) {

        this.id = id;
        this.address = address;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
