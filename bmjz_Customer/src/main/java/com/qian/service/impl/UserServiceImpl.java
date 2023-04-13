package com.qian.service.impl;

import com.qian.mapper.UserMapper;
import com.qian.model.User;
import com.qian.service.UserService;
import com.qian.utils.BatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public class UserServiceImpl implements UserService {

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
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    //4.可以开始使用对应mapper中的抽象方

    /** test ok
     * 实现注册，先检查 手机号是否为空，且是否已存在该手机号码；进行插入，比对插入结果
     * @param user
     * @return
     */
    @Override
    public String userRegister(User user) throws IOException {
        System.out.println("|||||||注册页面传来的user"+user.toString());
       if(user.getPhone_number()==""||user.getPassword()==""){
           return "注册失败，请检查信息是否正确";
       }else {
           User selectUser = userMapper.selectByPhone(user.getPhone_number());
           int insertResult = 0;
           if(selectUser==null){//
               insertResult = userMapper.insertNewUser(user.getUser_name(),user.getPhone_number(),user.getPassword());
           }else {
               System.out.println("该用户已存在");
               return "该用户已存在";
           }
           if(insertResult>0){
//               sqlSession.commit();
               return "success";
           }
       }
        return "注册失败，请检查信息是否正确";
    }

    /**
     *
     * @param phone_number
     * @param password
     * @return
     */
    @Override
    public User userLogin(String phone_number, String password) {
        User checkUser = userMapper.selectByPhonePwd(phone_number,password);
        return checkUser;
    }

    /**
     * 改  更新用户信息 by user_id
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        if(user==null) return -1;
        int updateResult = 0;
        updateResult = userMapper.updateUserById(user);
        if(updateResult>0){
            try{
                sqlSession.commit();
                System.out.println("\nupdate user Result="+updateResult);
                return updateResult;
            }catch (Exception e){
                sqlSession.rollback();
                System.out.println("a error in update user...");
                return -1;
            }
        }
        System.out.println("\nupdate user Result="+updateResult);
        return 0;
    }
}
