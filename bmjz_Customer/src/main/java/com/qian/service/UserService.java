package com.qian.service;

import com.qian.model.User;

import java.io.IOException;

public interface UserService {

    /**
     * 注册用户，传入一个用户对象，输出注册结果success or fail
     * @param user
     * @return
     */
    String userRegister(User user) throws IOException;

    /**
     * 用户登录 ，传入手机号和密码，返回登录结果
     * 一期不实现记住登录
     * @param phone_number
     * @param password
     * @return
     */
    User userLogin(String phone_number, String password);

    /**
     * 改  更新用户信息,依据user_id
     */
    int updateUser(User user);

}
