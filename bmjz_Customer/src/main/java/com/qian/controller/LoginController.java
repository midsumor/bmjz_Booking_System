package com.qian.controller;

import com.alibaba.fastjson.JSON;

import com.qian.model.User;
import com.qian.service.UserService;
import com.qian.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class LoginController {

    @RequestMapping(value = {"/loginPage"})
    public String toLoginPage(){
        return "login_page";
    }

    /** 0210 test ok
     * 处理登录的验证，以及登录成功后cookie的转码 写入
     */
    @RequestMapping(value = {"/login.do","/doLogin"})
    @ResponseBody   //springmvc自动接收来自浏览器的post中“username=zhansan&pwd=pwd"格式的数据
    public String doLogin(String phone_number, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService = new UserServiceImpl();
        User user = null;
        user = userService.userLogin(phone_number,password);

        if(user!=null){
            /**
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

        }else {
            return "fail";
        }

    }


    /**
     * 退出登录，删除页面的cookie
     * @return
     */

    @RequestMapping(value = {"/logout"})
    public String loginOut(){
        return "login_page";
    }



}
