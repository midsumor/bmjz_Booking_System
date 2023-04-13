package com.qian.controller;

import com.alibaba.fastjson.JSON;
import com.qian.model.Goods;
import com.qian.model.ShoppingCarItem;
import com.qian.service.GoodsService;
import com.qian.service.impl.GoodsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsController {

    /**
     * goods_manage page
     * @return
     */
    @RequestMapping(value = {"/goods_manage_page","/goodsManagePage"})
    public String goodsManagePage(){
        return "goods_manage";
    }

    /**
     *  删除  依据goods_id 删除对应Goods表中的数据
     * @param
     * @return
     */

    @RequestMapping(value = {"/deleteByGoodsId.one/{goods_id}"})
    @ResponseBody
    public String deleteByGoodsId(@PathVariable("goods_id")String goods_id){
        GoodsService goodsService = new GoodsServiceImpl();
        int deleteResult = 0;
        deleteResult = goodsService.removeGoodsByGoodsId(Integer.parseInt(goods_id));
        if(deleteResult>0){
            return "success";
        }else {
            return "fail";
        }
    }

    /**
     *  批量删除  依据goods_id_string解码出多个goods_id 批量 删除对应Goods表中的数据
     * @param
     * @return
     */
    @RequestMapping(value = {"/deleteByGoodsId.more/{goods_id_string}"})
    @ResponseBody
    public String deleteByGoodsIdMore(@PathVariable("goods_id_string")String goods_id_string){
        GoodsService goodsService  = new GoodsServiceImpl();
        if(goods_id_string==null){return "fail";}
        System.out.println(goods_id_string);
        String[] id_str_arr = goods_id_string.split("_");//获取成功
        int deleteResult = 0;
        for (String goods_id : id_str_arr){
            if(goods_id!=null&&goods_id!=""){
                deleteResult +=goodsService.removeGoodsByGoodsId(Integer.parseInt(goods_id));
                System.out.println("deleteResult="+deleteResult);
            }
        }
        if(deleteResult>0){
            return "成功移除"+deleteResult+"个预约项";
        }else {
            return "fail";
        }
    }


    /**
     *  改  更新一个商品的信息
     * @param
     * @return
     */
    @RequestMapping(value = {"/updateGoodsInfo"})
    @ResponseBody
    public String updateGoodsInfo(String goodsInfoString){
        System.out.println("goodsInfoString===="+goodsInfoString);
        //     jsonString转javabean User user = JSON.parseObject(jsonStr, User.class);
        Goods goods = null;
        try {
            goods = JSON.parseObject(goodsInfoString,Goods.class);// 前端数据 反序列化
        }catch (Exception e){
            System.out.println("goodsInfoString --> Goods fail");
            System.out.println(e);
            return "fail";
        }

        GoodsService goodsService = new GoodsServiceImpl();
        int updateResult = goodsService.editGoodsInfo(goods);
        if(updateResult>0){
            return "success";
        }else {
            return "fail";
        }

    }



    /**
     * 查  所有用户都可以 查看所有未下架的商品 即goods_status=1 ！=0
     * 直接返回List对象？？？前端也是直接拿来用，可能是thymeleaf自动处理了
     *    注意   返回的List对象，到达前端后可以直接赋值给js数组
     * @param
     * @return
     */
    @RequestMapping(value = {"/getGoodsList","/getAllGoodsList"})
    @ResponseBody
    public List<Goods> getGoodsListInCar(){
        GoodsService goodsService = new GoodsServiceImpl();
        List<Goods> goodsList = null;
        goodsList = goodsService.findAllGoods();
        System.out.println("查询到"+goodsList.size()+"条goods数据。。。");
        return goodsList;
    }


    /** ok
     * 增
     * @param goods_json_string
     * @return
     */
    @RequestMapping(value = {"/addGoods","/addNewGoods"})
    @ResponseBody
    public String addNewGoods(String goods_json_string){
        System.out.println(goods_json_string);// 获取成功json_string
        Goods goods = null;
        try{
            goods = JSON.parseObject(goods_json_string,Goods.class);
            System.out.println(goods.toString());
        }catch (Exception e){
            System.out.println("json_string 转译失败");
            return "fail";
        }
        GoodsService goodsService = new GoodsServiceImpl();
        int insertResult = 0;
        insertResult = goodsService.addGoods(goods);
        System.out.println("添加商品数量："+insertResult);
        if(insertResult>0){
            return "success";
        }else {
            return "fail";
        }

    }

}
