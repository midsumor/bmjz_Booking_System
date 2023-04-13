package com.qian.controller;

import com.alibaba.fastjson.JSON;
import com.qian.model.Admin;
import com.qian.service.AdminService;
import com.qian.service.impl.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class AdminLoginController {

    /**
     * 页面
     */
    @RequestMapping(value = {"/admin_login_page","/adminLoginPage"})
    public String adminLoginPage(){
        return "admin_login_page";
    }

    /**
     * 处理 管理员登录
     * @param account
     * @param password
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/admin_login","/login.do","adminLogin"})
    @ResponseBody
    public String login(String account, String password, HttpServletRequest request, HttpServletResponse response){
        AdminService adminService = new AdminServiceImpl();
        Admin admin = null;
        admin = adminService.findAdmin(account,password);

        if(admin!=null){
            /**
             * 	Cookie cookie1 = new Cookie("cookie1","cookie1's value");
             * 	resp.addCookie(cookie1);
             * 	对字符串进行编码，才能存入cookie
             * 	前端js对cookie字符串进行解码 成正常json格式字符串
             * 	let decodeCookieString = decodeURIComponent(getCookieByName('userDataJson'));// 进行解码test ok
             *  let user_cookie_list = JSON.parse(decodeCookieString);// string to object of json
             */
            //       java对象转JSON    json转java对象 User user = JSON.parseObject(jsonStr, User.class);
            String adminJson =  JSON.toJSONString(admin);
            adminJson = URLEncoder.encode(adminJson, StandardCharsets.UTF_8);// 对字符串进行编码，才能存入cookie
            Cookie adminCookie = new Cookie("adminDataJson",adminJson);
            adminCookie.setMaxAge(7*24*60*60*1000);// 七天
            response.addCookie(adminCookie);
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
        return "admin_login_page";
    }


}
