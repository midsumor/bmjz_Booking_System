package com.qian.service.impl;

import com.qian.mapper.ShoppingCarMapper;
import com.qian.model.ShoppingCarItem;
import com.qian.service.ShoppingCarService;
import com.qian.utils.BatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class ShoppingCarServiceImpl implements ShoppingCarService {
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
    ShoppingCarMapper carMapperr = sqlSession.getMapper(ShoppingCarMapper.class);
    //4.可以开始使用对应mapper中的抽象方


    /** test ok
     * add和update操作  注意提交事务，或者打开自动提交
     * 增加 一个商品到 购物车
     * @param carItem
     * @return
     */
    @Override
    public int addGoodsItem(ShoppingCarItem carItem) {
        int addResult = 0;
        addResult = carMapperr.addGoodsToCar(carItem);
        if(addResult>0){
            try{
                sqlSession.commit();
                System.out.println("\nadd goods to shopping car Result="+addResult);
                return addResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in add goods to shopping car");
                return -1;
            }
        }
        System.out.println("0条数据添加");
        return 0;
    }

    /** test ok
     * 删除  依据car_id删除shopping_car中的数据
     *
     */
    @Override
    public int deleteByCarId(int car_id) {
        int deleteResult = 0;
        deleteResult = carMapperr.deleteByCarId(car_id);
        if(deleteResult>0){
            try{
                sqlSession.commit();
                System.out.println("购物车删除 "+deleteResult+" 条数据");
                return deleteResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in add goods to shopping car");
                return -1;
            }
        }
        System.out.println("购物车删除 0 条数据");
        return 0;
    }

    /** test ok
     * 查
     * @param user_id
     * @return
     */
    @Override
    public List<ShoppingCarItem> getCarListByUid(int user_id) {
        List<ShoppingCarItem> carItemList = null;
        carItemList = carMapperr.selectCarItemByUid(user_id);
        System.out.println("\n从购物车查询数据"+carItemList);
        return carItemList;
    }


}
