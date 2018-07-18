package com.example.jedis.test.test2;

import com.example.jedis.test.Use;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Consumer;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/28
 *
 * Lambda表达式基础语法
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LambadDemo {

    /**
     * 首先Lambda表示其实是在匿名内部类中进行升级的其实就是匿名方法的实现，所以在->中，左侧和右侧就是参数和执行体
     * jaba8中引用新的操作符。成为箭头操作符->
     * 箭头操作符将Lambda表达式拆成两个部分
     * 左侧：Lambda 表达式的参数列表   就是方法的传入数据
     * 右侧：Lambda 表达式的功能体
     *
     *
     * 语法格式一：无参数，无返回值
     * () -> System.out.println("wwwwwww");
     *
     *  语法格式二：有一个参数，无返回值
     *  Consumer<String> consumer = o -> System.out.println(o);
     *
     *
     * 语法格式三：有一个参数，小括号可以不写
     * Consumer<String> consumer = o -> System.out.println(o);


       语法格式四：有两个参数，有返回值，Lambda有多条语句,用{}
           Comparator<Integer> con = (x,y) -> {
                System.out.println("Sss");
                return Integer.compare( x,y );
         };
     *
     * 语法格式五： Lambda有一条语句  大括号和return都可以不写
     *  Comparator<Integer> con = (x,y) -> Integer.compare( x,y );
     *
     */
    @Test
    public void test01() {
       Runnable r1 = new Runnable( ) {
           @Override
           public void run() {
               System.out.println("ss");
           }
       };
       r1.run();

       Runnable r2 = () -> System.out.println("dds");
       r2.run();

    }


    final List<Use> userList  = Arrays.asList(
            new Use( "a",1,35 ),
            new Use( "b",6,25 ),
            new Use( "c",5,56 ),
            new Use( "d",3,89 ),
            new Use( "e",8,78 )
    );

    @Test
    public void test02() {
        Consumer<String> consumer = o -> System.out.println(o);
        consumer.accept( "sd" );
    }


    @Test
    public void test03() {
        Consumer<String> consumer = (o) -> System.out.println(o);
        consumer.accept( "sd" );
    }


    /**
     * 语法格式四：有两个参数，有返回值，Lambda有多条语句,要使用{},且要return返回
     *
     * 在有参数时，可以不用指定参数的类型，因为java虚拟机可以进行类型判断，通过上下文进行类型推断
     */
    @Test
    public void test04() {
        Comparator<Integer> con = (x,y) -> {
            System.out.println("Sss");
            return Integer.compare( x,y );
        };
    }


    /**
     * 语法格式五： Lambda有一条语句  大括号和return都可以不写
     */
    public void test05() {
        Comparator<Integer> con = (x,y) -> Integer.compare( x,y );
    }


    /**
     * 二
     *
     * Lambda表达式需要“函数式接口”的支持
     * 函数式接口： 接口中只有一个抽象方法的接口，可以使用注解@FunctionalInterface修改
     * 可以检查接口是否是函数式接口。
     */



    @Test
    public void test6() {
        Integer n = gtf( 100,(x) -> x+8 );

    }


    public Integer gtf(Integer i,SchoolServer schoolServer) {
        return schoolServer.filter( i );
    }





    @Test
    public void test7() {
        //自定义实现语句
        SchoolServer schoolServer = (x) -> x+9;
        //执行
        Integer s = schoolServer.filter( 10 );
        System.out.println(s);


    }


    /**
     * 排序
     */
    @Test
    public void test8() {
        Collections.sort( userList,(l1,l2) -> {
           if(l1.getId().equals( l2.getId() )) {
               System.out.println(l1.getId().compareTo( l2.getId() ));
                return l1.getId().compareTo( l2.getId() );
           }else {
               return Integer.compare( l1.getId(),l2.getId() );
           }
        });

        userList.forEach( u -> System.out.println(u));
    }


    /**
     * 字符串处理
     */
    @Test
    public void test9() {
        String ss = filtre( "a s " ,(s) -> s.toLowerCase()  );
        System.out.println(ss);
    }



    public String filtre(String s,MyFuction myFuction) {
        return myFuction.getString( s );

    }




    @Test
    public void test10() {
        geyLong( 11L,12L,(x1,x2) -> x1+x2 );
    }


    public void geyLong(Long l1,Long l2,DemoFuction<Long, Long> demoFuction) {
        System.out.println(demoFuction.filterFution( l1,l2 ));
    }

















































}
