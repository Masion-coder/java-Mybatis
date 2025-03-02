package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mapper.UserMapper;

@SpringBootTest // SpringBoot单元测试的注解 - 当前测试类中的测试方法运行时，会启动SpringBoot应用 - IOC容器
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        userMapper.findAll().forEach(System.out::println);
    }
}
