// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package com.unionpay.serializer.protobuf.user;

public interface UserOrderOrBuilder extends
    // @@protoc_insertion_point(interface_extends:user.UserOrder)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 id = 1;</code>
   */
  long getId();

  /**
   * <code>optional int64 gmtCreate = 2;</code>
   */
  long getGmtCreate();

  /**
   * <code>optional sint32 money = 3;</code>
   */
  int getMoney();

  /**
   * <code>optional string location = 4;</code>
   */
  java.lang.String getLocation();
  /**
   * <code>optional string location = 4;</code>
   */
  com.google.protobuf.ByteString
      getLocationBytes();
}