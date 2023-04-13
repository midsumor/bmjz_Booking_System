package com.qian.service;

import com.qian.model.Goods;

import java.util.List;

/**
 * Admin   GoodsService
 */
public interface GoodsService {

    /**
     * 查  查询所有goods信息
     * @return
     */
    List<Goods> findAllGoods();


    /**
     * 删  by goods_id
     * @param goods_id
     * @return
     */
    int removeGoodsByGoodsId(int goods_id);

    /**
     * 改 by new goods object
     * @param goods
     * @return
     */
    int editGoodsInfo(Goods goods);

    /**
     * 增
     * @param goods
     * @return
     */
    int addGoods(Goods goods);
}
