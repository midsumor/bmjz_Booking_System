package com.qian.service.impl;

import com.qian.mapper.AdminMapper;
import com.qian.model.Admin;
import com.qian.service.AdminService;
import com.qian.utils.BatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public class AdminServiceImpl implements AdminService {
    //1.使用工具类获取SqlSessionFactory
    BatisUtils batisUtils = new BatisUtils();
    SqlSessionFactory sqlSessionFactory;
    {
        try {
            sqlSessionFactory = batisUtils.getSqlSessionFactoryByBatis();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    SqlSession sqlSession = sqlSessionFactory.openSession(true); //打开自动提交
    //3. 获取对应Mapper
    AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
    //4.可以开始使用对应mapper中的抽象方

    /**
     * 查 依据 输入的管理员账号 密码，来查询匹配
     * @param account
     * @param password
     * @return
     */
    @Override
    public Admin findAdmin(String account, String password) {
        Admin findAdmin = null;
        findAdmin = adminMapper.selectByAcountPwd(account,password);
        return findAdmin;
    }
}
