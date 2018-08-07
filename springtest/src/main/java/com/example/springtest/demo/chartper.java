package com.example.springtest.demo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class chartper {



    @Test
    public void testf() {
        //1、读取配置文件实例化一个IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("hello.xml");
        //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
        TestDmoApi helloApi = context.getBean("hello", TestDmoApi.class);
        //3、执行业务逻辑
        helloApi.say();
    }
}
