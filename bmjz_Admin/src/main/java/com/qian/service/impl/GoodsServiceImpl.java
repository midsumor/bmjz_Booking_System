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

    /** test ok
     * 查  查询所有goods信息
     * @return goodsList
     */
    @Override
    public List<Goods> findAllGoods() {
        List<Goods> goodsList = null;
        goodsList = goodsMapper.selectAllGoods();
        return goodsList;
    }

    /** test ok
     * 删
     * @param goods_id
     * @return
     */
    @Override
    public int removeGoodsByGoodsId(int goods_id) {
        int deleteResult = 0;
        deleteResult = goodsMapper.deleteByGoodsId(goods_id);
        if(deleteResult>0){
            try{
                sqlSession.commit();
                System.out.println("\ndelete goods by goods_id Result="+deleteResult);
                return deleteResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in delete goods by goods_id");
                return -1;
            }
        }
        System.out.println("删除0个goods");
        return 0;
    }


    /**
     * 改  更新 goods信息，不包括图片
     * @param goods
     * @return
     */
    @Override
    public int editGoodsInfo(Goods goods) { // test ok
        if(goods==null) return -1;
        int updateResult = 0;
        updateResult = goodsMapper.updateGoods(goods);
        if(updateResult>0){
            try{
                sqlSession.commit();
                System.out.println("\nupdate goods info Result="+updateResult);
                return updateResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in update goods info");
                return -1;
            }
        }
        System.out.println("更新了0条goods数据");
        return 0;
    }

    /**
     * 增
     * @param goods
     * @return
     */
    @Override
    public int addGoods(Goods goods) {
//        images/goods_img/login-bg-3.jpg
        String gidJpg = "images/goods_img/"+goods.getGoods_id()%55+".jpg";
        goods.setGoods_img(gidJpg);
        int insertResult = 0;
        insertResult = goodsMapper.insertGoods(goods);
        if(insertResult>0){
            try{
                sqlSession.commit();
                System.out.println("\nadd goods Result="+insertResult);
                return insertResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in add goods");
                return -1;
            }
        }
        System.out.println("存入0条商品信息");
        return 0;
    }
}
