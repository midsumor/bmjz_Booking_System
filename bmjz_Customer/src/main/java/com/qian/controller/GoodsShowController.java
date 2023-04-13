package com.qian.controller;


import com.alibaba.fastjson.JSON;
import com.qian.model.Category;
import com.qian.model.Goods;
import com.qian.service.GoodsService;
import com.qian.service.impl.GoodsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsShowController {

    /**
     * 保洁服务 one
     * 纺织物清洗 two
     * 家电清洁 three
     * 其它 four
     * @param columns
     * @return
     */

    @RequestMapping(value = {"/goodsList/{columns}"})
    @ResponseBody
    public List<Goods> goodsShow(@PathVariable("columns") String columns){
        Category category = new Category();
        GoodsService goodsService = new GoodsServiceImpl();
        List<Goods> goodsList = goodsService.goodsShow(category.getCategory(columns));
        System.out.println("\n\n"+goodsList);
        //       java对象转JSON    json转java对象 User user = JSON.parseObject(jsonStr, User.class);
        //            String goodsJsonString = JSON.toJSONString(goodsList).substring(1,JSON.toJSONString(goodsList).length()-1);
        return goodsList;

    }

    @RequestMapping(value = {"/goodsShowPageOne"})
    public String goodsShowPageOne(){
        return "goods_show_one";
    }
    @RequestMapping(value = {"/goodsShowPageTwo"})
    public String goodsShowPageTwo(){
        return "goods_show_two";
    }
    @RequestMapping(value = {"/goodsShowPageThree"})
    public String goodsShowPageThree(){
        return "goods_show_three";
    }
    @RequestMapping(value = {"/goodsShowPageFour"})
    public String goodsShowPageFour(){
        return "goods_show_four";
    }

}
