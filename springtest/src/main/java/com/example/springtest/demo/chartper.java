package com.example.springtest.demo;

import com.example.springtest.pojo.*;
import com.example.springtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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


    /**
     * 通过别名去获取bean
     */
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext( "hello.xml" );
        TestDmoApi helloApi = context.getBean("ddd1", TestDmoApi.class);
        helloApi.say();
    }



    @Test
    public void tst02() {
        ApplicationContext context = new ClassPathXmlApplicationContext( "hello.xml" );
        StudentService helloApi = context.getBean("tets1", StudentService.class);
        helloApi.sayHello();
    }

    @Test
    public void tst03() {
        ApplicationContext context = new ClassPathXmlApplicationContext( "hello.xml" );
        StudentService helloApi = context.getBean("bean3", StudentService.class);
        helloApi.sayHello();
    }






    @Test
    public void test04() {
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );
        Persion persion = context.getBean( "student00" , Persion.class );
        System.out.println(persion);
    }

    @Test
    public void test05() {
//        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );
//        Car car1 = context.getBean( "car001" , Car.class );
//        Car car2 = context.getBean( "car001" , Car.class );
//        System.out.println(car1 == car2);


        Wkn wkn = new Wkn();
        wkn.setCarName( "eeeeee" );
        System.out.println(wkn.getCarName());



    }





    @Test
    public String test06(String i , String j) {
        if (!StringUtils.isEmpty( i )) {
            return i;
        }
        if (!StringUtils.isEmpty( j )) {
            return j;
        }
        return i+j+"ab";
    }





    @Test
    public void test07() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "bean2.xml" );
        BeanTest persion = context.getBean( "bean01" , BeanTest.class );
        System.out.println(persion);
        //关闭容器
        context.close();
    }



    @Test
    public void test08() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "bean2.xml" );
        MyBeanPostProcessor persion = context.getBean( "beantest1" , MyBeanPostProcessor.class );
        System.out.println(persion);
        //关闭容器
        context.close();
    }

    @Test
    public void test09() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "beanFactory.xml" );
        Car  persion = (Car) context.getBean( "carF1" );
        System.out.println(persion);
        //关闭容器
        context.close();
    }



    @Test
    public void test010() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "beanFactory.xml" );
        Car  persion = (Car) context.getBean( "car4" );
        System.out.println(persion);
        //关闭容器
        context.close();
    }


    @Test
    public void test011() {
//        ApplicationContext context = new ClassPathXmlApplicationContext( "configration1.xml" );
//        UserRepositoryImpl persion = (UserRepositoryImpl) context.getBean( "userRepositoryImpl" );
//        System.out.println(persion);

        for(int i = 0;i<50;++i) {
            System.out.println(getId());
        }



    }

    private  long tmpID = 0;

    private  boolean tmpIDlocked = false;

    public  long getId()
    {
        long ltime = 0;
        while (true)
        {
            if(tmpIDlocked == false)
            {
                tmpIDlocked = true;
                //当前：（年、月、日、时、分、秒、毫秒）*10000
                ltime = Long.valueOf(new SimpleDateFormat("yyMMddhhmmssSSS").format(new Date()).toString()) * 10000;
                if(tmpID < ltime)
                {
                    tmpID = ltime;
                }
                else
                {
                    tmpID = tmpID + 1;
                    ltime = tmpID;
                }
                tmpIDlocked = false;
                return ltime;
            }
        }
    }






    public String test08(String str) {
        return Optional.ofNullable( str )
                .map( (x) -> {
                    return "a";
                } ).orElse( "aaa" );
    }



    @Test
    public void test00() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = (UserService) context.getBean( "userService" );
        userService.add();
    }


}
