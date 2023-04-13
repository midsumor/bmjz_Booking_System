package com.qian.service.impl;

import com.alibaba.fastjson.JSON;
import com.qian.mapper.OrderMapper;
import com.qian.model.Order;
import com.qian.model.ShoppingCarItem;
import com.qian.service.OrderService;
import com.qian.utils.BatisUtils;
import com.qian.utils.ChiyaTool;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    //1.使用工具类获取SqlSessionFactory
    BatisUtils batisUtils = new BatisUtils();
    SqlSessionFactory sqlSessionFactory;
    {
        try {
            sqlSessionFactory = batisUtils.getSqlSessionFactoryByBatis();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    SqlSession sqlSession = sqlSessionFactory.openSession(); // open the auto commit
    //3. 获取对应Mapper
    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
    //4.可以开始使用对应mapper中的抽象方


    /**
     * 查 未开始
     * @return
     */
    @Override
    public List<Order> getOrderListIng() {
        List<Order> orderList = null;

        try {
            orderList  = orderMapper.selectOrderIng();
            /**
             * 将字符串 goods_info_json 转化 为 链表 goodsInfoList
             * 可参照oneNote笔记
             */
            for (Order order : orderList) {
                String goods_info_json = order.getGoods_info_json();
                List<ShoppingCarItem> goodsInfoList = JSON.parseArray(goods_info_json,ShoppingCarItem.class);
                System.out.println("goodsInfoList测试长度"+goodsInfoList.size());
                order.setGoodsInfoList(goodsInfoList);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("订单表查询结果："+orderList);

        return orderList;
    }


    /**
     * 查  全部
     * @return
     */
    @Override
    public List<Order> getAllOrderList() {
        List<Order> orderList = null;

        try {
            orderList  = orderMapper.selectOrderAll();
            /**
             * 将字符串 goods_info_json 转化 为 链表 goodsInfoList
             * 可参照oneNote笔记
             */
            for (Order order : orderList) {
                String goods_info_json = order.getGoods_info_json();
                List<ShoppingCarItem> goodsInfoList = JSON.parseArray(goods_info_json,ShoppingCarItem.class);
                System.out.println("goodsInfoList测试长度"+goodsInfoList.size());
                order.setGoodsInfoList(goodsInfoList);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("订单表查询结果："+orderList);

        return orderList;
    }






    /**
     * 改 依据 order_id 更改订单状态
     * @param order_id
     * @param order_status
     * @return
     */
    @Override
    public int startOrder(int order_id, String order_status) {
        int updateResult = 0;
        updateResult = orderMapper.updateOrderStatus(order_id,order_status);
        if(updateResult>0){
            try{
                sqlSession.commit();
                System.out.println("\nupdate order in order_data table Result="+updateResult);
                return updateResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in update order to order_data table");
                return -1;
            }
        }
        return 0;
    }
}
