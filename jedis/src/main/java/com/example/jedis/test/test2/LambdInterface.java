package com.example.jedis.test.test2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LambdInterface {

    /**
     * java8四大核心函数式接口
                 * Consumer<T> :消费接口
                 *      void accept(T t);
                 *
                 *
                 * Suppliter<T>:供给型接口
                 *      T get();
                 *
                 *
                 * Function<T,R>:函数型接口
                 *      R apply(T t);
                 *
                 *
                 * Predicate<T> : 断言型接口
                 *      boolean test(T t);
     */







    /**
     * Consumer<T> :消费接口
     */
    @Test
    public void test1() {
        happy( 100,(x) -> System.out.println("消费"+x));
    }

    public void happy(double d, Consumer<Double> consumer) {
        consumer.accept( d );
    }


    /**
     *Suppliter<T>:供给型接口
     */
    @Test
    public void test2() {
        List <Integer> i = getLsut(10,() -> (int)Math.random()*100);
        i.forEach( (o) -> System.out.println(o));
    }

    /**
     * 得到任意长度的集合
     * @param i
     * @param supplier
     * @return
     */
    public List<Integer> getLsut(int i, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList <>(  );
        for(int j = 0;i<=i;++j) {
            Integer integer = supplier.get();
            list.add( integer );
        }
        return list;
    }

    /**
     *Function<T,R>:函数型接口
     */
    @Test
    public void test3() {
        getString( "sdfds  ",(x1) -> x1.trim() );
    }

    /**
     * 去掉字符串中的空格
     * @param s
     * @param function
     * @return
     */
    public String getString(String s, Function<String,String> function) {
            return function.apply( s );
    }


    /**
     *Predicate<T> : 断言型接口
     */
    @Test
    public void test4() {
        List<String> sli = Arrays.asList( "dddd","fgg","gfjjg","fsdfsgdf" );
        List<String> list = checkString(sli,(s) -> s.length()>5);
        list.forEach( (s) -> System.out.println(s));
    }


    /**
     * 将满足条件的数据放在集合中
     */
    public List<String> checkString(List<String> list, Predicate<String> predicate) {
        List<String> slist = new ArrayList <>(  );
        list.forEach( (o) -> {
            if(predicate.test( o )) {
                slist.add( o );
            }
        } );
        return slist;
    }

























}
