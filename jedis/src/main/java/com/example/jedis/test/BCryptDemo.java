package com.example.jedis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/7/18
 *
 * BCrypt  加密
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BCryptDemo {


    @Test
    public void test1() {

        String password = "wu123456";
        String s = BCrypt.hashpw( password,"a" );
        System.out.println(s);
    }
}
