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


    /** ok
     * 增加  将一个Order对象 写入 shopping_car table
     * @param order
     * @return 插入结果
     */
    @Override
    public int insertOrder(Order order) {
        if(order==null) return -1;
        int insertResult = 0;
        insertResult = orderMapper.insertAOrder(order);
        if(insertResult>0){
            try{
                sqlSession.commit();
                System.out.println("\ninsert goods to order_data table Result="+insertResult);
                return insertResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in insert goods to order_data table");
                return -1;
            }
        }else {
            return 0;
        }
    }


    /** ok
     * 查  依据user_id 查询订单表
     * @param user_id
     * @return
     */
    @Override
    public List<Order> getOrderListByUid(int user_id) {
        ChiyaTool chiyaTool = new ChiyaTool();
        List<Order> orderList = null;

        try {
            orderList  = orderMapper.selectOrdersByUid(user_id);
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
            System.out.println("getOrderListByUid(int user_id)出错了");
        }
        System.out.println("订单表查询结果："+orderList);
        /** test ok
         * 对结果按 order_status排序
         */
        return chiyaTool.sortOrderByStatus(orderList);
    }

    /** test ok
     * 删  依据order_id删除订单信息
     * 非安全 存在越权调用
     * @param order_id
     * @return
     */
    @Override
    public int deleteOrderByOid(int order_id) {
        int deleteResult = 0;
        deleteResult = orderMapper.deleteOrderByOid(order_id);
        if(deleteResult>0){
            try{
                sqlSession.commit();
                System.out.println("\ndelete order in order_data table Result="+deleteResult);
                return deleteResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in delete order to order_data table");
                return -1;
            }
        }else {
            return 0;
        }
    }

    /** ok
     * 改 依据 order_id 更改订单状态
     * @param order_id
     * @param order_status
     * @return
     */
    @Override
    public int finishOrder(int order_id, String order_status,String end_time) {
        int updateResult = 0;
        System.out.println("订单完成时间："+end_time);
        updateResult = orderMapper.updateOrderStatusEndTime(order_id,order_status,end_time);
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
