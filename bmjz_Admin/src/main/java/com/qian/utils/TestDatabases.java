//package com.qian.utils;
//
//
//import com.qian.mapper.UserMapper;
//import com.qian.model.User;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//
//import java.io.IOException;
//import java.util.List;
//
///**
// *   //1.使用工具类获取SqlSessionFactory
// *         BatisUtils batisUtils = new BatisUtils();
// *         SqlSessionFactory sqlSessionFactory = batisUtils.getSqlSessionFactoryByBatis();
// *         SqlSession sqlSession = sqlSessionFactory.openSession();
// *         //3. 获取对应Mapper
// *         DatabasesTestMapper testMapper =sqlSession.getMapper(DatabasesTestMapper.class);
// */
//public class TestDatabases {
//    public static void main(String[] args) throws IOException {
//        //1.使用工具类获取SqlSessionFactory
////        BatisUtils batisUtils = new BatisUtils();
////        SqlSessionFactory sqlSessionFactory = batisUtils.getSqlSessionFactoryByBatis();
////        SqlSession sqlSession = sqlSessionFactory.openSession();
////        //3. 获取对应Mapper
////        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
////        //4.可以开始使用对应mapper中的抽象方法
////
////        List<User> allUserList = userMapper.getAllUser();
////        System.out.println(allUserList.toString());
//
//
//    }
//}
