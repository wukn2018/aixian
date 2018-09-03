package com.example.springtest.AspectJDemo.test;

import com.example.springtest.AspectJDemo.service.MateInter;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class ApplicationTest {


    @Test
    public void test010() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "application1.xml" );
        MateInter persion = (MateInter) context.getBean( "mathInterImpl" );
        persion.add( 1 );
        //关闭容器
        context.close();
    }


    @Test
    public void test02() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "bean3.xml" );
        MateInter persion = (MateInter) context.getBean( "m1" );
        persion.add( 1 );
        //关闭容器
        context.close();
    }



















}
