package com.qian.mapper;

import com.qian.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用于处理 商品的查询
 */

public interface GoodsMapper {

    @Select("select * from goods where category=#{category}")
    public List<Goods> selectByCategory(@Param("category") String category);
}
