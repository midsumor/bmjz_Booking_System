package com.qian.service.impl;

import com.alibaba.fastjson.JSON;
import com.qian.model.*;
import com.qian.service.OrderService;
import com.qian.service.ShoppingCarService;
import com.qian.service.UserService;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestImpl {


    public static void main(String[] args) {
        /**Category  GoodsServiceImpl
         * test ok
         */
//        Category category = new Category();
//        GoodsServiceImpl goodsService =new GoodsServiceImpl();
//        List<Goods> goodsList = goodsService.goodsShow(category.getCategory("two"));
//        List<Goods> goodsList1 = goodsService.goodsShow(category.getCategory("tw"));
//        System.out.println(goodsList.toString());
//        System.out.println("toJSONString"+JSON.toJSONString(goodsList).substring(1,JSON.toJSONString(goodsList).length()-1)); // String
//        System.out.println(goodsList1);

        /**test ok
         * 操作的数据库 表：shopping_car
         * 测试 addGoodsItem
         * 测试 getCarListByUid
         * 测试 deleteByCarId   ok
         * 测试 insertOder(order) ok
         */
//        ShoppingCarItem carItem = new ShoppingCarItem();
//        carItem.setUser_id(2);carItem.setGoods_name("厨房清扫");carItem.setGoods_num(1);
//        carItem.setGoods_price(40);carItem.setGoods_img("images/login-bg-2.jpg");
//        ShoppingCarService shoppingCarService = new ShoppingCarServiceImpl();
//        shoppingCarService.addGoodsItem(carItem);
//        shoppingCarService.getCarListByUid(1);
//        int deleteResult = 0;
//        deleteResult = shoppingCarService.deleteByCarId(9);
//        System.out.println("deleteResult="+deleteResult);

        OrderService orderService = new OrderServiceImpl();
//        Order order = new Order();
//        order.setUser_name("测试orderservice");order.setUser_id(1);
//        int insertResult = orderService.insertOrder(order);
//        System.out.println("insertResult="+insertResult);

//        List<Order> orderList = orderService.getOrderListByUid(1);
//        System.out.println(orderList==null);
//        System.out.println("delete by order_id test:"+orderService.deleteOrderByOid(15));// test ok
        /**
         * orderList排序测试
         */
//        for (Order order1 : orderList) {
//            System.out.println("orderList before sort  "+order1.getOrder_status());
//        }
//        List<Order> sortList = new ArrayList<Order>();
//
//        for (Order order1 : orderList) {
//            if(order1.getOrder_status().equals("未开始")){
//                sortList.add(order1);
//            }
//        }
//        for (Order order1 : orderList) {
//            if(order1.getOrder_status().equals("进行中")){
//                sortList.add(order1);
//            }
//        }
//        for (Order order1 : orderList) {
//            if(order1.getOrder_status().equals("已完成")){
//                sortList.add(order1);
//            }
//        }

//        for (Order order1 : sortList) {
//            System.out.println("orderList after sort  "+order1.getOrder_status());
//        }
        // test update order_status
//        System.out.println("update order_status result="+orderService.finishOrder(16,"已完成test","完成时间test"));

        /**OK
         * 测试updateUser()
         *
         * 注意，处理如果有值为空，应该写入 空字符串或者0
         */
//        UserService userService = new UserServiceImpl();
//        User user = new User();user.setUser_id(2);user.setUser_name("Test_name");user.setPassword("123");
//        user.setPhone_number("123456");user.setAddress("");user.setGender("nan");
//        int updateResult = userService.updateUser(user);
//        System.out.println("updateResult:"+updateResult);
    }

}
