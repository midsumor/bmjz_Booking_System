package com.qian.service;

import com.qian.model.Goods;

import java.util.List;

public interface GoodsService {

    /**
     *  处理商品页面展示的数据，依据传入的category参数进行查询
     *  采用的是严格查询，如 “其它”的分类，也需要有“其它”这个参数
     */
    public List<Goods> goodsShow(String category);
}
