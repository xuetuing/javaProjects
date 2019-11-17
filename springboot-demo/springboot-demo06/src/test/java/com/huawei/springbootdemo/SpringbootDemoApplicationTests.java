package com.huawei.springbootdemo;

import com.huawei.springbootdemo.bean.User;
import com.huawei.springbootdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootDemoApplicationTests {

    @Autowired
    private UserMapper mapper;

    @Test
    void insert() {
        User user = new User();
        user.setName("测试");
        user.setCreateTime(new Date());
        int result = mapper.insert(user);
        System.out.println(result);
    }

}
