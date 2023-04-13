package com.qian.controller;


import com.qian.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    @RequestMapping(value = {"/login","/loginController"})
    public String testPage(){

        return "login_page";
    }

    @RequestMapping(value = {"/register","/registerController"})
    public String testPage2(){

        return "register_page";
    }
    // get data from pages.from browser to controller is ok

    @RequestMapping("/checkLogin")
    @ResponseBody
    public String getData(User pageUser){
        System.out.println(pageUser.toString());
        return "<h1>登录成功</h2>";
    }

    @RequestMapping("/checkRegister")
    @ResponseBody
    public String getData2(User pageUser){
        System.out.println(pageUser.toString());
        return "<h1>注册成功</h2>";
    }

    //get data from databases;test is ok

}
