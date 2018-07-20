package com.example.jedis.test;

import com.example.jedis.contans.CMSCodeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        //密码
        String password = "wu123456";

        /**
         * 加密
         */
        String s = BCrypt.hashpw( password,BCrypt.gensalt() );
        System.out.println(s);


        /**
         * 解密
         */
        Boolean b = BCrypt.checkpw( password,s );
        System.out.println(b);


    }


    @Test
    public void test12() {
        int i = 1;
        for(int a = 0;a<3;++a) {
            try {
                System.out.println("111");
                if(i/a>1) {
                    System.out.println("ssss");
                }
                System.out.println("222");
            } catch (Exception e) {
                System.out.println("333");
               throw e;
            }
            finally {
                System.out.println("4444");
            }
            System.out.println("5555");
        }

        System.out.println("6666");
    }




    @Test
    public void tets4() {
        List<String> list = new ArrayList <>(  );
        list.add( "Aaa" );
        list.add( "Aaa" );
        System.out.println(list);
    }


    @Test
    public void test2() {
        String s = null;
        Optional optional = Optional.ofNullable( s )
                .map( (x) -> CMSCodeEnum.PlanNameEnum.getByName( s ));
        if(optional.isPresent()) {
            int plantformId = (int) optional.get();
        }
        System.out.println("ssss");
    }





}
