package com.example.jedis.test;

import com.example.jedis.test.bean.FilterUseSaleImpl;
import com.example.jedis.test.bean.FilterUser;
import com.example.jedis.test.bean.FilterUserImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Java8Test {

   final List<Use> userList  = Arrays.asList(
            new Use( "a",1,35 ),
            new Use( "b",3,25 ),
            new Use( "c",5,56 ),
            new Use( "d",7,89 ),
            new Use( "e",8,78 )
    );

    /**
     * 过滤id
     */
    @Test
    public void test01() {
        List<Use> list = new ArrayList <>(  );
        for(Use us:userList) {
            if(us.getId()>5) {
                list.add( us );
            }
        }
        System.out.println(list);
    }

    /**
     * 过滤salter
     */
    @Test
    public void test06() {
        List<Use> list = new ArrayList <>(  );
        for(Use us:userList) {
            if(us.getSaler()>78) {
                list.add( us );
            }
        }
        System.out.println(list);
    }



    @Test
    public void test03() {
        Comparator<Integer> con = new Comparator <Integer>( ) {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare( o1,o2 );
            }
        };
        TreeSet<Integer> treeSet = new TreeSet <>();
        treeSet.add( 1 );
        treeSet.add( 2 );
        treeSet.add( 3 );
        for (Integer i:treeSet) {
            System.out.println(i);
        }
    }

    /**
     * Lambda表达式
     */
    Comparator<Integer> comparator = (x,y) -> Integer.compare( x,y );


    /**
     *
     * @param list
     * @param filterUser
     */
    public void test02(List<Use> list, FilterUser<Use> filterUser) {
        List<Use> l = new ArrayList <>(  );
        for(Use user:list) {
            if(filterUser.checkUser( user )) {
                l.add( user );
            }
        }
        System.out.println(l);
    }


    /**
     * 优化方式一
     * 这样对一个类中的属性进行过滤时，可要直线接口就可以实现，降低很多垃圾代码
     */
    @Test
   public void tesd() {
        /**
         * 过滤id
         */
       test02( userList,new FilterUserImpl() );

        /**
         * 过滤salter
         */
        test02( userList,new FilterUseSaleImpl() );

   }


    /**
     * 优化方式二
     * 匿名内部类
     *
     */
    @Test
    public void test1() {
        test02( userList, new FilterUser <Use>( ) {
            @Override
            public Boolean checkUser(Use o) {
                //想要过滤那个属性就在这里直接判断，不需要再去实现多个接口
                return o.getId()>5?true:false;
            }
        } );
    }


    /**
     * 优化方式三
     * Lambda表达式
     */
    public void test2() {
        test02( userList,(u) -> u.getId()>5?true:false );
    }


    /**
     * 优化方式四
     */
    @Test
    public void test3() {
        userList.stream()
                .filter( (use -> use.getId()>5?true:false) )
                .forEach(System.out::println);

        userList.stream()
                .map( Use::getSaler ).forEach( System.out::println )    ;
    }



















































}

