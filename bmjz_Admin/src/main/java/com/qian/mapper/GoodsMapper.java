package com.qian.mapper;

import com.qian.model.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 管理员端的GoodsMapper   负责处理Goods表的操作
 */

public interface GoodsMapper {

    /**
     * 查
     * 管理员端，可以查看所有状态下的所有商品信息
     * @return
     */
    @Select("select * from goods")
    List<Goods> selectAllGoods();


    /**
     * 删
     */
    @Delete("delete from goods where goods_id=#{goods_id}")
    int deleteByGoodsId(@Param("goods_id")int goods_id);


    /**
     * 改 更新商品信息
     * @param newGoodsInfo
     * @return
     *     @Update("update user set user_name=#{user_name},phone_number=#{phone_number},gender=#{gender}," +
     *             "address=#{address} where user_id=#{user_id}")
     *     int updateUserById(User user);
     */
    @Update("update goods set goods_name=#{goods_name},goods_descript=#{goods_descript},goods_price=#{goods_price}," +
            "category=#{category},goods_status=#{goods_status} where goods_id=#{goods_id}")
    int updateGoods(Goods newGoodsInfo);

    /**
     * 增  插入一个新商品信息
     * @param goods
     * @return
     */
    @Insert("insert into goods(goods_name,goods_descript,goods_price,category,goods_img,goods_status)" +
            "values(#{goods_name},#{goods_descript},#{goods_price},#{category},#{goods_img}," +
            "#{goods_status})")
    int insertGoods(Goods goods);

}
