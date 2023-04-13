package com.qian.model;


public class Goods {

  private int goods_id;
  private String goods_name;
  private String goods_descript;
  private String goods_price;
  private String category;
  private int goods_num;
  private String goods_img;
  private String goods_status;


  @Override
  public String toString() {
    return "Goods{" +
            "goods_id=" + goods_id +
            ", goods_name='" + goods_name + '\'' +
            ", goods_descript='" + goods_descript + '\'' +
            ", goods_price='" + goods_price + '\'' +
            ", category='" + category + '\'' +
            ", goods_num=" + goods_num +
            ", goods_img='" + goods_img + '\'' +
            ", goods_status='" + goods_status + '\'' +
            '}';
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

  public String getGoods_descript() {
    return goods_descript;
  }

  public void setGoods_descript(String goods_descript) {
    this.goods_descript = goods_descript;
  }

  public String getGoods_price() {
    return goods_price;
  }

  public void setGoods_price(String goods_price) {
    this.goods_price = goods_price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getGoods_num() {
    return goods_num;
  }

  public void setGoods_num(int goods_num) {
    this.goods_num = goods_num;
  }

  public String getGoods_img() {
    return goods_img;
  }

  public void setGoods_img(String goods_img) {
    this.goods_img = goods_img;
  }

  public String getGoods_status() {
    return goods_status;
  }

  public void setGoods_status(String goods_status) {
    this.goods_status = goods_status;
  }
}
