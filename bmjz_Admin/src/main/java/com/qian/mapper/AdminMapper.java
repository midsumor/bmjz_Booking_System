package com.qian.mapper;

import com.qian.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    /**
     * 查
     * @param account
     * @param password
     * @return
     */
    @Select("select * from admin where account=#{account} and password=#{password}")
    Admin selectByAcountPwd(@Param("account") String account,@Param("password")  String password);// test ok
}
