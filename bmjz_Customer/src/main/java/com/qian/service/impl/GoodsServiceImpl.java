package com.qian.service.impl;

import com.qian.mapper.GoodsMapper;
import com.qian.model.Goods;
import com.qian.service.GoodsService;
import com.qian.utils.BatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
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

    SqlSession sqlSession = sqlSessionFactory.openSession();
    //3. 获取对应Mapper
    GoodsMapper goodsMapper = sqlSession.getMapper(GoodsMapper.class);
    //4.可以开始使用对应mapper中的抽象方

    @Override
    public List<Goods> goodsShow(String category) {
        List<Goods> goodsList = null;
        goodsList = goodsMapper.selectByCategory(category);// category=one,two,three...
        System.out.println("impl\n"+goodsList);
        return goodsList;
    }

}
