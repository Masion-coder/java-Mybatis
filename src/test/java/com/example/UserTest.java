package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.UserMapper;
import com.example.module.User;

@SpringBootTest // SpringBoot单元测试的注解 - 当前测试类中的测试方法运行时，会启动SpringBoot应用 - IOC容器
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        userMapper.findAll().forEach(System.out::println);
    }

    /*
     * 测试删除用户
     */
    @Test
    public void testDeleteById() {
        Integer n = userMapper.deleteById(5);
        System.out.println("删除行数：" + n);
    }

    /*
     * 测试新增
     */
    @Test
    public void testInsert() {
        User user = new User(null, "abc", "5678", "kun", 30);
        userMapper.insert(user);
    }

    /*
     * 测试更新
     */
    @Test
    public void testUpdate() {
        User user = new User(6, "kun", "5678", "坤", 30);
        userMapper.update(user);
    }

    /*
     * 测试根据用户名和密码查询用户
     */
    @Test
    public void testFindByUsernameAndPassword() {
        User user = userMapper.findByUsernameAndPassword("kun", "5678");
        System.out.println(user);
    }
}
