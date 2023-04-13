package com.qian.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *   //1.使用工具类获取SqlSessionFactory
 *         BatisUtils batisUtils = new BatisUtils();
 *         SqlSessionFactory sqlSessionFactory = batisUtils.getSqlSessionFactoryByBatis();
 *         SqlSession sqlSession = sqlSessionFactory.openSession();
 *         //3. 获取对应Mapper
 *         DatabasesTestMapper testMapper =sqlSession.getMapper(DatabasesTestMapper.class);
 */


public class BatisUtils {
    /**
     *
     * @return sqlSessionFactory
     * @throws IOException
     */
    public SqlSessionFactory getSqlSessionFactoryByBatis() throws IOException {
        InputStream inputStream = null;
        SqlSessionFactory sqlSessionFactory = null;
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        inputStream = Resources.getResourceAsStream(resource);//输入流读取文件
        // 通过inputString 读入配置文件后，按照配置文件，build一个sql会话对象工厂 实例
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;

    }
}
