package com.qian.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.qian.model.User;
import com.qian.service.UserService;
import com.qian.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@Controller
public class UserController {


    //前往页面
    @RequestMapping(value = {"/userInfoPage"})
    public String userInfoPage(){
        return "user_info_edit";
    }


    /**
     *  改  处理用户更改个人信息的请求， 在正确更新用户信息后，将新的用户信息重新写入cookie  userDataJson
     * @param userInfoString
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = {"/updateUserInfo"})
    @ResponseBody
    public String updateUserInfo(String userInfoString,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        UserService userService = new UserServiceImpl();

        System.out.println("用户信息更新:"+userInfoString);
        if(userInfoString==null||userInfoString=="") return "user info is empty";
        User user = null;
        try{
            /**jsonString -> javaObject   ok
             * ---自定义的分隔符为 "<e|e>"，前端已处理最后一个分隔符，直接使用即可
             * 阿里的json库可以自动处理 “[ {},{},{} ]” json元素组成的数组，转化为java实体类，注意格式的保持
             * 数据接收成功 data:"user_id="+user_cookie_list['user_id']+"&goodsListString="+str
             */
            JSONObject userJson = JSONObject.parseObject(userInfoString);
            user = JSON.toJavaObject(userJson,User.class);
            System.out.println("转为javabean："+user);
        }catch (Exception e){
            System.out.println("an error in update user info");
            return "system error";
        }
        int updateResult = 0;
        updateResult = userService.updateUser(user);
        if(updateResult>0){
            /**更新用户数据后，进行userDataJson cookie的回写
             * 	Cookie cookie1 = new Cookie("cookie1","cookie1's value");
             * 	resp.addCookie(cookie1);
             * 	对字符串进行编码，才能存入cookie
             * 	前端js对cookie字符串进行解码 成正常json格式字符串
             * 	let decodeCookieString = decodeURIComponent(getCookieByName('userDataJson'));// 进行解码test ok
             *  let user_cookie_list = JSON.parse(decodeCookieString);// string to object of json
             */
            //       java对象转JSON    json转java对象 User user = JSON.parseObject(jsonStr, User.class);
            String userJson =  JSON.toJSONString(user);
            userJson = URLEncoder.encode(userJson, StandardCharsets.UTF_8);// 对字符串进行编码，才能存入cookie
            Cookie userCookie = new Cookie("userDataJson",userJson);
            userCookie.setMaxAge(7*24*60*60*1000);// 七天
            response.addCookie(userCookie);

            return "success";
        }else{
            return "fail";
        }
    }


}
