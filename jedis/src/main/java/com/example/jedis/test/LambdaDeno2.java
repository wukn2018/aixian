package com.example.jedis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */

/**
 * 方法引用：
 *      若Lambda体中的的内容有方法以及实现了，我们就可以使用“方法引用”
 *         （可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *
 *  方法格式：
 *     对象::实例方法名
 *
 *     类::静态方法名
 *
 *     类::实例方法名
 *
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LambdaDeno2 {


    @Test
    public void test1() {
        haap( 12,(x) -> System.out.println(x+1));
    }

    public void haap(double d,Consumer<Double> consumer) {
        consumer.accept( d );
    }


    /**
     *  对象::实例方法名
     */
    public void test2() {
        Consumer<Double> consumer = (x) -> System.out.println("ss"+x);


        /**
         * 要使用方法引用是使 实现的方法返回值类型和参数类型和执行的方法返回值和参数类型一样
         */
        Consumer<Double> consumer1 = System.out::print;
    }

    @Test
    public void test3() {
        Use u = new Use( "Sd",1,2 );
        Supplier<String> s = () -> u.getName();
        s.get();
        Supplier<String> ss = u::getName;
    }


    /**
     *  类::静态方法名
     */
    public void test4() {
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x,y);
        Comparator<Integer> c = Integer::compare;
    }


    /**
     * 类::实例方法名
     */
    public void test5() {
        //参数列表的第一个参数是实例方法的调用者，第二个参数是实例方法的参数。
        BiPredicate<String,String> bb = (x,y) -> x.equals( y );

        BiPredicate<String,String> b = String::equals;
    }


    /**
     * 构造器引用
     *
     *
     */
    public void test6() {
        Supplier<Use> ss = () -> new Use( "s",1,2 );
        ss.get();
        //构造器引用  调用无参的构造器
        Supplier<Use> s = Use::new;
        s.get();
    }


    /**
     * 数组引用
     */
    @Test
    public void test7() {
        Function<Integer,String[]> ff = (x) -> new String[x];

        Function<Integer,String[]> f = String[]::new;
        String[] s = f.apply( 20 );
        System.out.println(s.length);
    }





















}
