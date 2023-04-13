package com.qian.service;

import com.qian.model.Admin;

public interface AdminService {

    /**
     * 依据传入的非空admin对象，提取其账号和密码来 在数据库中查询，结果返回为一个admin对象
     * @param
     * @return
     */
    Admin findAdmin(String account, String password);
}
