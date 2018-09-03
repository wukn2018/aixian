package com.example.springtest.web.test;

import com.example.springtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class TestDemo {


    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("configration1.xml");
        UserService userService = (UserService) context.getBean( "userService" );
        userService.add();
    }
}
