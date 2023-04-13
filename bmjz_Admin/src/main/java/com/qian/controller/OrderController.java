package com.qian.controller;

import com.qian.model.Order;
import com.qian.service.OrderService;
import com.qian.service.impl.OrderServiceImpl;
import com.qian.utils.ChiyaTool;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @RequestMapping(value = {"/orderProcessPae","/order_process"})
    public String orderProcessPage(){
        return "order_process";
    }


    @RequestMapping(value = {"/orderHistoryPage"})
    public String orderHistoryPage(){
        return "order_history_page";
    }


    /**
     * 查  未开始的订单
     * @param
     * @return
     *
     * 注意 可以直接传List对象过去给前端，前端获取后直接赋值给js数组即可 var orderList[];
     */
    @RequestMapping(value = {"/getOrderListIng"})
    @ResponseBody
    public List<Order> getOrderListIng(){
        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = null;
        orderList = orderService.getOrderListIng();

        return orderList;
    }

    /**
     * 查  所有 进行中和已完成的
     * @param
     * @return
     *
     * 注意 可以直接传List对象过去给前端，前端获取后直接赋值给js数组即可 var orderList[];
     */
    @RequestMapping(value = {"/getOrderListAll"})
    @ResponseBody
    public List<Order> getOrderListAll(){
        ChiyaTool chiyaTool = new ChiyaTool();
        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = null;
        orderList = orderService.getAllOrderList();

        return chiyaTool.sortOrderByStatus(orderList);
    }






    /** ok
     * 改  update a order in order_data by order_id
     * @param order_id
     * @return
     */
    @RequestMapping(value = {"/startOrder/{order_id}"})
    @ResponseBody
    public String finishOrder(@PathVariable("order_id") String order_id){
        OrderService orderService = new OrderServiceImpl();
        int updateResult = 0;
        updateResult = orderService.startOrder(Integer.parseInt(order_id),"进行中");
        System.out.println("update order result = "+updateResult);
        if(updateResult>0){
            return "success";
        }else {
            return "fail";
        }
    }
}
