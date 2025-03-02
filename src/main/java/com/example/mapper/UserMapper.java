package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.module.User;

@Mapper // 应用程序在运行时，MyBatis 会自动扫描这个接口，并创建一个代理对象，并且将这个代理对象注册到 Spring 容器中
public interface UserMapper {

    /*
     * 查询所有用户
     */
    
    @Select("select * from user")
    public List<User> findAll();

    /*
     * 根据id删除用户
     */
    // @Delete("delete from user where id = ${id}") // ${} 表示直接替换，不需要预编译，同静态SQL
    @Delete("delete from user where id = #{id}") // #{} 表示预编译，需要预编译，同动态SQL
    public Integer deleteById(Integer id);

    /*
     * 新增用户
     */
    @Insert("insert into user(username, password, name, age) values (#{username}, #{password}, #{name}, #{age})")
    public Integer insert(User user);

    /*
     * 根据id、密码更新用户
     */
    @Update("update user set username = #{username}, name = #{name}, age = #{age} where id = #{id} and password = #{password}")
    public Integer update(User user);
}
