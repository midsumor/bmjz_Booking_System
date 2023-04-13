package com.qian.service;

import com.qian.model.Order;

import java.util.List;

public interface OrderService {

    /**
     * 查
     * @param
     * @return
     */
    List<Order> getAllOrderList();

    /**
     * 查 未开始
     * @param
     * @return
     */
    List<Order> getOrderListIng();

    /**
     * 改 依据 order_id 更改订单状态 进行中
     * @param order_id
     * @param order_status
     * @return
     */
    int startOrder(int order_id,String order_status);
}
