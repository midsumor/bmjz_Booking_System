package com.qian.model;

import java.util.List;

public class Order {


    private int order_id;
    private int user_id;
    private String user_name;
    private String phone_number;
    private String address;
    private String create_time;
    private String service_time;
    private String end_time;
    private String order_note;
    private String order_status;
    private Double sum_price;
    private String goods_info_json;
    private List<ShoppingCarItem> goodsInfoList;


    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", create_time='" + create_time + '\'' +
                ", service_time='" + service_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", order_note='" + order_note + '\'' +
                ", order_status='" + order_status + '\'' +
                ", sum_price=" + sum_price +
                ", goods_info_json='" + goods_info_json + '\'' +
                '}';
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getService_time() {
        return service_time;
    }

    public void setService_time(String service_time) {
        this.service_time = service_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Double getSum_price() {
        return sum_price;
    }

    public void setSum_price(Double sum_price) {
        this.sum_price = sum_price;
    }

    public String getGoods_info_json() {
        return goods_info_json;
    }

    public void setGoods_info_json(String goods_info_json) {
        this.goods_info_json = goods_info_json;
    }

    public List<ShoppingCarItem> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<ShoppingCarItem> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }
}
