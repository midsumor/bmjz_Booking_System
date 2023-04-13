package com.qian.mapper;

import com.qian.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 *  '#{user_name}'号表示查询语句的参数占位
 *  注意检查sql有没有写错
 *  *注意#号必须搭配@Param注解使用@Param注解是为了映射实体类和数据库字段名字不同而出现的，如上面的phonenumber映射成phone
 *@Insert("insert into user(id,name) values(#{id},#{name})")
 * public int insert(User user); // 插入一个对象时的操作方式
 */

public interface UserMapper {

// 1,查找数据库是否已存在某个手机号
    @Select("select * from user where phone_number=#{phone_number}")
    User selectByPhone(String phone_number);
//2,插入一条数据到用户数据库
    @Insert("insert into user(user_name,phone_number,password) values(#{user_name},#{phone_number},#{password})")
    int insertNewUser(@Param("user_name") String user_name,
                      @Param("phone_number") String phone_number, @Param("password") String password);

//3,通过账号密码共同定位到数据库是否有该用户
    @Select("select * from user where phone_number=#{phone_number} and password=#{password}")
    User selectByPhonePwd(@Param("phone_number") String phone_number,@Param("password") String password);


    @Update("update user set user_name=#{user_name},phone_number=#{phone_number},gender=#{gender}," +
            "address=#{address} where user_id=#{user_id}")
    int updateUserById(User user);


    @Select("select * from user")
    List<User> getAllUser();


}
