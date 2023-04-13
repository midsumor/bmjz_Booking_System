package com.qian.controller;

import com.alibaba.fastjson.JSON;
import com.qian.model.ShoppingCarItem;
import com.qian.service.ShoppingCarService;
import com.qian.service.impl.ShoppingCarServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShoppingCarController {

    ShoppingCarService shoppingCarService = new ShoppingCarServiceImpl();

    @RequestMapping(value = {"/shoppingCarPage"})
    public String shoppingCarPage(){
        return "shopping_car";
    }


    /**
     * 增加 到shpping_car
     * @param user_id
     * @param goodsListString
     * @return
     */
    @RequestMapping(value = {"/addGoodsListToCar"})
    @ResponseBody
    public String addGoodsToCar(String user_id,String goodsListString){
        /**goodsListString --> ShoppingCarItem Object   ok
         * ---自定义的分隔符为 "<e|e>"，前端已处理最后一个分隔符，直接使用即可
         * 阿里的json库可以自动处理 “[ {},{},{} ]” json元素组成的数组，转化为java实体类，注意格式的保持
         * 数据接收成功 data:"user_id="+user_cookie_list['user_id']+"&goodsListString="+str
         */
        List<ShoppingCarItem> itemList = JSON.parseArray("["+goodsListString+"]",ShoppingCarItem.class);

        int addResult = 0;
        for(ShoppingCarItem item : itemList){
            item.setUser_id(Integer.parseInt(user_id));
            addResult += shoppingCarService.addGoodsItem(item);
        }
        System.out.println("\n添加到购物车表的数据："+addResult);
        return "success";
    }


    /**
     *  删除
     * @param car_id
     * @return
     */
    @RequestMapping(value = {"/deleteByCarId.one/{car_id}"})
    @ResponseBody
    public String deleteByCarIdOne(@PathVariable("car_id") String car_id){
        if(car_id==null){return "fail";}
        System.out.println("oneOrMore=one");
        int carId_int = Integer.parseInt(car_id);
        int deleteResult = 0;
        deleteResult = shoppingCarService.deleteByCarId(carId_int);
        if(deleteResult>0){
            System.out.println("controller deleteByCarId删除一条数据");
            return "success";
        }else {
            return "fail";
        }
    }// end

    /**
     * 批量删除
     * @param car_id_string
     * @return
     */
    @RequestMapping(value = {"/deleteByCarId.more/{car_id_string}"})
    @ResponseBody
    public String deleteByCarIdMore(@PathVariable("car_id_string") String car_id_string){
        if(car_id_string==null){return "fail";}
        System.out.println(car_id_string);
        String[] id_str_arr = car_id_string.split("_");//获取成功
        int deleteResult = 0;
        for (String str : id_str_arr){
            if(str!=null&&str!=""){
                int temp_int = Integer.parseInt(str);
                deleteResult += shoppingCarService.deleteByCarId(temp_int);
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
     * 查  直接返回List对象？？？前端也是直接拿来用，可能是thymeleaf自动处理了
     * @param user_id
     * @return
     */
    @RequestMapping(value = {"/getGoodsListInCar/{user_id}"})
    @ResponseBody
    public List<ShoppingCarItem> getGoodsListInCar(@PathVariable("user_id")int user_id){

        List<ShoppingCarItem> carItemList = null;
        carItemList = shoppingCarService.getCarListByUid(user_id);

        return carItemList; // 将从购物车表中查询到的数据用List装，再响应到前端
    }
}
