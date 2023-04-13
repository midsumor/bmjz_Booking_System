package com.qian.utils;

import com.qian.model.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChiyaTool {

    /**
     * 按格式返回现在的时间的字符串  yyyy-MM-dd hh:mm:ss
     * @return
     */
    public String getDateTime(){
        // 初始化 Date 对象
        Date now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        // 使用 toString() 函数显示日期时间
        System.out.println(now.toString());
        System.out.println("格式化\t"+ft.format(now));

        return ft.format(now);
    }


    /** test ok
     * 对结果按 order_status排序
     * @param orderList
     * @return
     */
    public List<Order> sortOrderByStatus(List<Order> orderList){
//        for (Order order1 : orderList) {
//            System.out.println("orderList before sort  "+order1.getOrder_status());
//        }
        List<Order> sortList = new ArrayList<Order>();

        for(int i=orderList.size()-1;i>=0;i--){ // 这样处理 是为了让新的 为开始订单 排在前面
            if(orderList.get(i).getOrder_status().equals("未开始")){
                sortList.add(orderList.get(i));
            }
        }
        for(int i=orderList.size()-1;i>=0;i--){ // 这样处理 是为了让新的 为开始订单 排在前面
            if(orderList.get(i).getOrder_status().equals("进行中")){
                sortList.add(orderList.get(i));
            }
        }
        for(int i=orderList.size()-1;i>=0;i--){ // 这样处理 是为了让新的 为开始订单 排在前面
            if(orderList.get(i).getOrder_status().equals("已完成")){
                sortList.add(orderList.get(i));
            }
        }


//        for (Order order1 : sortList) {
//            System.out.println("orderList after sort  "+order1.getOrder_status());
//        }
        return sortList;
    }

}
