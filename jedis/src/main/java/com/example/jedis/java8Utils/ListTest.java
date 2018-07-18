package com.example.jedis.java8Utils;

import com.example.jedis.test.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/7
 *
 * java8   List  forEach
 */
public class ListTest {

    public static void main(String[] args) {
        forEach03();
    }


    public static void forEach01() {
        List<User> list = getList();
        list.sort(comparing(User::getName)
        .thenComparing(  User::getId).reversed());
        list.forEach( ll -> System.out.println(ll));
    }


    /**
     * map  遍历
     */
    public static void forEach02() {
        Map<String,Object> map = new HashMap <>(  );
        map.put( "1","a" );
        map.put( "2","b" );
        map.put( "3","c" );
        map.put( "4","d" );
        map.put( "5","e" );

        //传统遍历map方式
        for (Map.Entry mm : map.entrySet()) {
            System.out.println(mm.getKey()+""+mm.getValue());
        }

        // java8  forEach遍历
        map.forEach( (k,v) -> {
                if("a".equals( v )) {
                    System.out.println("sssss");
                }
                });
    }


    /**
     * list遍历
     */
    public static void forEach03() {

        // java8  forEach遍历
        List<User> list = getList();
        list.forEach( ll -> {
            System.out.println(ll);
        } );
    }
















    /**
     * 获取list
     * @return
     */
    public static List<User> getList() {
        List<User> list = new ArrayList<>(  );
        list.add( new User( "a",11 ) );
        list.add( new User( "f",6 ) );
        list.add( new User( "d",7 ) );
        list.add( new User( "k",5 ) );
        list.add( new User( "h",56 ) );
        list.add( new User( "g",97 ) );
        list.add( new User( "u",25 ) );
        list.add( new User( "y",99 ) );
        list.add( new User( "t",53));
        list.add( new User( "r",100 ) );
        list.add( new User( "e",98 ) );
        list.add( new User( "q",4 ) );
        list.add( new User( "l",1 ) );
        list.add( new User( "z",2 ) );
        list.add( new User( "x",8 ) );
        list.add( new User( "c",3 ) );
        list.add( new User( "v",96 ) );
        list.add( new User( "b",74 ) );
        list.add( new User( "m",9 ) );
        return list;
    }

}
