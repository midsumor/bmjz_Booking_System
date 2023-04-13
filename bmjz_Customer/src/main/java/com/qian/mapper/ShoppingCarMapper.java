package com.qian.mapper;

import com.qian.model.ShoppingCarItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShoppingCarMapper {


    /**
     * 增
     *  *@Insert("insert into user(id,name) values(#{id},#{name})")
     *  * public int insert(User user); // 插入一个对象时的操作方式
     *  ###处理重复插入数据的问题，将user_id和goods_name绑定为唯一索引,若已存在user_id和goods_name同时相同的量则只更新goods_num
     *  insert into shopping_car(user_id,goods_name,goods_num) values(1,'家具搬运',6) ON DUPLICATE KEY UPDATE goods_num=goods_num+6;
     */
    @Insert("insert into shopping_car(user_id,goods_id,goods_name,goods_num,goods_price,goods_img) values(#{user_id},#{goods_id}," +
            "#{goods_name},#{goods_num},#{goods_price},#{goods_img}) ON DUPLICATE KEY UPDATE goods_num=goods_num+#{goods_num}")
    public int addGoodsToCar(ShoppingCarItem carItem);

    /**
     * 删
     */
    @Delete("delete from shopping_car where car_id=#{car_id}")
    public int deleteByCarId(@Param("car_id")int car_id);

    /**
     * 查  依据user_id从购物车表中查询所有数据
     */
    @Select("select * from shopping_car where user_id=#{user_id}")
    public List<ShoppingCarItem> selectCarItemByUid(@Param("user_id") int user_id);

}
