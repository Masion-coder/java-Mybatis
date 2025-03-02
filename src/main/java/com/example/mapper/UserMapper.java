package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.module.User;

@Mapper // 应用程序在运行时，MyBatis 会自动扫描这个接口，并创建一个代理对象，并且将这个代理对象注册到 Spring 容器中
public interface UserMapper {

    /*
     * 查询所有用户
     */
    
    @Select("select * from user")
    public List<User> findAll();
}
