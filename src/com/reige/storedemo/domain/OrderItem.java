package com.reige.storedemo.domain;

/**
 * Created by REIGE on 2017/7/6.
 */
public class OrderItem {
    private String order_id;//订单号
    private String product_id;//商品号
    private int buynum;//购买数量

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }
}
