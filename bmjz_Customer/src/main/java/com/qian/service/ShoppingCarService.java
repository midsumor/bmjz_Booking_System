package com.qian.service;

import com.qian.model.ShoppingCarItem;

import java.util.List;

public interface ShoppingCarService {

    /**
     * 增加  将商品信息和对应操作的user_id加入到shopping_car table
     * @param carItem
     * @return
     */
    public int addGoodsItem(ShoppingCarItem carItem);

    /**
     * 删除  依据car_id删除shopping_car中的数据
     */
    public int deleteByCarId(int car_id);



    /**
     * 查询  依据user_id获取购物车中对应数据
     */
    public List<ShoppingCarItem> getCarListByUid(int user_id);



}
