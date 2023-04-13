package com.qian.service;

import com.qian.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    /**
     * 增  往订单表中插入一个订单对象
     * @param order
     * @return
     */
    int insertOrder(Order order);

    /**
     * 查  依据user_id 查询订单表
     * @param user_id
     * @return
     */
    List<Order> getOrderListByUid(int user_id);

    /**
     * 删  依据 order_id  删除订单信息
     * @param order_id
     * @return
     */
    int deleteOrderByOid(int order_id);

    /**
     * 改 依据 order_id 更改订单状态
     * @param order_id
     * @param order_status
     * @return
     */
    int finishOrder(int order_id,String order_status,String end_time);
}
