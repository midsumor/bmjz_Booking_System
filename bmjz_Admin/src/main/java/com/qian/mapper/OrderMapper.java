package com.qian.mapper;

import com.qian.model.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderMapper {

    /**
     * 查  依据user_id从订单车表中查询所有数据
     */
    @Select("select * from order_data where order_status!='未开始'")
    List<Order> selectOrderAll();

    /**
     * 查  未开始的订单
     */
    @Select("select * from order_data where order_status='未开始'")
    List<Order> selectOrderIng();

    /**
     * 改  依据order_id更新 订单状态
     * update order_data set order_status='进行中进行中' where order_id = 15;
     */
    @Update("update order_data set order_status=#{order_status} where order_id=#{order_id}")
    int updateOrderStatus(@Param("order_id")int order_id,@Param("order_status")String order_status);


}
