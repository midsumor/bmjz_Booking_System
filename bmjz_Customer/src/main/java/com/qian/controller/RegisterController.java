package com.qian.controller;

import com.qian.model.User;
import com.qian.service.UserService;
import com.qian.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller

public class RegisterController {

    @RequestMapping(value = {"/registerPage"})
    public String toRegisterPage(){
        return "register_page";
    }

    /**
     * 处理注册 请求 test ok
     * @param user
     * @return
     * @throws IOException
     */
    @RequestMapping(value = {"/register.do"})
    @ResponseBody
    public String doRegister(User user) throws IOException {
        UserService userService = new UserServiceImpl();
        String registerResult = userService.userRegister(user);
        return registerResult;//success,"该用户已存在" or fail
    }
}
