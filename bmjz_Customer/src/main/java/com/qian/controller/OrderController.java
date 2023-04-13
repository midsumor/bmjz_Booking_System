package com.qian.controller;

import com.alibaba.fastjson.JSON;
import com.qian.model.Order;
import com.qian.model.ShoppingCarItem;
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



    /** ok
     * 增   添加订单信息
     * 往order table中插入一条数据，使用Order类作为参数，要求实体类和数据库字段名完全一致
     * 需要注意的是goods_info_json  是一个商品信息组成的 数组 元素为json形式串
     *order_status ： 未开始，进行中，已完成
     * 处理 shopping_car.html中的业务
     */
    @RequestMapping(value = {"/createOrder"})
    @ResponseBody
    public String createOrder(String user_id,String user_name,String phone_number,String address,String service_time,
                              String order_note,String goodsListString){
        if(goodsListString==null){return "fail";}//注意 应该判断goods_info_json是否有数据，才能进行后续写入操作
        ChiyaTool chiyaTool = new ChiyaTool();
        OrderService orderService = new OrderServiceImpl();
        System.out.println(goodsListString);
        // 因为是从购物车页面发起的请求，多以商品的信息 来自shopping_car表，故使用对应的类 来存储转化后的List

        /**goods_info_string 注意，解析的时候使用JSON.parseArray（goods_info_string，ShoppingCarItem.class)
         *[ {"car_id":95,"user_id":1,"goods_id":1,"goods_name":"棉衣洗护",....},{.....},{.....} ]
         */
        String goods_info_string = "["+goodsListString+"]";
        List<ShoppingCarItem> goodsList = JSON.parseArray(goods_info_string,ShoppingCarItem.class);// ok
        Double sum_price = 0.00;
        for (ShoppingCarItem goods : goodsList) {
            sum_price += goods.getGoods_price()*goods.getGoods_num();
        }
                System.out.println("该订单总价：\t"+sum_price);
                System.out.println("goods_info_string："+goods_info_string);
                System.out.println(user_id+"\t"+user_name+"\t"+phone_number+"\t"+address+" "+service_time+" "+order_note);
        Order order = new Order();
            order.setUser_id(Integer.parseInt(user_id));order.setUser_name(user_name);order.setPhone_number(phone_number);
            order.setAddress(address);order.setService_time(service_time);order.setOrder_note(order_note);
            order.setOrder_status("未开始");order.setSum_price(sum_price);
            order.setGoods_info_json(goods_info_string);
            order.setCreate_time(chiyaTool.getDateTime());//写入现在的时间字符串yyyy-MM-dd hh:mm:ss
                System.out.println("订单信息："+order.toString());

        // 开始写入 写入成功返回结果1 失败返回0 异常返回-1
        int insertResult = 0;
        insertResult = orderService.insertOrder(order);
        if(insertResult>0){
            return "success";
        }else {
            return "fail";
        }
    }// end createOrder()


    /** ok
     * 显示 我的订单页面
     * @return
     * 处理my_oders_page.html的业务
     */
    @RequestMapping(value = {"/myOrderPage"})
    public String myOrderPage(){
        return "my_order_page";
    }

    /**
     * 查 依据user_id在order_data表中查找对应的 订单信息
     * @param user_id
     * @return
     *
     * 注意 可以直接传List对象过去给前端，前端获取后直接赋值给js数组即可 var orderList[];
     */
    @RequestMapping(value = {"/getOrderListByUid/{user_id}"})
    @ResponseBody
    public List<Order> getOrderListByUid(@PathVariable("user_id") String user_id){
        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = null;
        orderList = orderService.getOrderListByUid(Integer.parseInt(user_id));

        return orderList;
    }

    /**
     * 删  delete a order by order_id
     * @param order_id
     * @return
     */
    @RequestMapping(value = {"/deleteOrderByOid/{order_id}"})
    @ResponseBody
    public String deleteOrderByOid(@PathVariable("order_id") String order_id){
        OrderService orderService = new OrderServiceImpl();
        int deleteResult = 0;
        deleteResult = orderService.deleteOrderByOid(Integer.parseInt(order_id));
        if(deleteResult>0){
            return "success";
        }else {
            return "fail";
        }

    }

    /** ok
     * 改  update a order in order_data by order_id
     * @param order_id
     * @return
     */
    @RequestMapping(value = {"/finishOrder/{order_id}"})
    @ResponseBody
    public String finishOrder(@PathVariable("order_id") String order_id){
        ChiyaTool chiyaTool = new ChiyaTool();
        OrderService orderService = new OrderServiceImpl();
        int updateResult = 0;
        String end_time = chiyaTool.getDateTime();
        updateResult = orderService.finishOrder(Integer.parseInt(order_id),"已完成",end_time);
        System.out.println("update order result = "+updateResult);
        if(updateResult>0){
            return "success";
        }else {
            return "fail";
        }
    }

}
