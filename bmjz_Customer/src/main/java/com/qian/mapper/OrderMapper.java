package com.qian.mapper;

import com.qian.model.Order;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {

    /** ok
     * 增
     * @Insert("insert into user(id,name) values(#{id},#{name})")
     * 往order table中插入一条数据，使用Order类作为参数，要求实体类和数据库字段名完全一致
     * @param order
     * @return
     */
    // ==***  注意： order 是sql的关键字 排序order by，所以数据库表名，不能使用  注意**===
    @Insert("INSERT INTO order_data(user_id,user_name,phone_number,address,service_time,create_time," +
            "order_note,order_status,sum_price,goods_info_json) values(#{user_id},#{user_name},#{phone_number}," +
            "#{address},#{service_time},#{create_time},#{order_note},#{order_status},#{sum_price},#{goods_info_json})")
    int insertAOrder(Order order);

    /**
     * 查  依据user_id从订单车表中查询所有数据
     */
    @Select("select * from order_data where user_id=#{user_id}")
    List<Order> selectOrdersByUid(@Param("user_id") int user_id);

    /**
     * 删  依据order_id删除order_data表中的数据
     * 非安全的方法 存在越权调用
     */
    @Delete("delete from order_data where order_id=#{order_id}")
    int deleteOrderByOid(int order_id);

    /**
     * 改  依据order_id更新 订单状态
     * update order_data set order_status='进行中进行中' where order_id = 15;
     */
    @Update("update order_data set order_status=#{order_status},end_time=#{end_time} where order_id=#{order_id}")
    int updateOrderStatusEndTime(@Param("order_id")int order_id,@Param("order_status")String order_status,@Param("end_time")String end_time);


}
