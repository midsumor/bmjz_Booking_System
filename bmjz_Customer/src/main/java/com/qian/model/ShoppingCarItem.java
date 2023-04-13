package com.qian.model;

public class ShoppingCarItem {

    private int car_id;
    private int user_id;
    private int goods_id;
    private String goods_name;
    private int goods_num;
    private double goods_price;
    private String goods_img;


    @Override
    public String toString() {
        return "ShoppingCarItem{" +
                "car_id=" + car_id +
                ", user_id=" + user_id +
                ", goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_num=" + goods_num +
                ", goods_price=" + goods_price +
                ", goods_img='" + goods_img + '\'' +
                '}';
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }
}
