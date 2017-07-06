package com.reige.storedemo.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by REIGE on 2017/7/6.
 */
public class Order implements Serializable{
    private String id; // 订单号
    private double money; // 金额
    private String receiverinfo; // 收货人信息
    private int paystate; // 支付状态
    private Timestamp ordertime; // 下单时间
    private int user_id; // 下单用户
    private List<OrderItem> items;// 订单中订单项

    // 添加用户昵称和用户名字段
    private String username;
    private String nickname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getReceiverinfo() {
        return receiverinfo;
    }

    public void setReceiverinfo(String receiverinfo) {
        this.receiverinfo = receiverinfo;
    }

    public int getPaystate() {
        return paystate;
    }

    public void setPaystate(int paystate) {
        this.paystate = paystate;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
