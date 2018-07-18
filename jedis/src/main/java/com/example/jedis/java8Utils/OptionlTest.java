package com.example.jedis.java8Utils;

import com.example.jedis.test.User;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * @Author : Wukn
 * @Date : 2018/6/5
 * Optinal类的使用
 */
public class OptionlTest {


    public static void main(String[] args) {
        //ofTest();
        //ofNullableTest();
        lambdaTest02();
    }


    public static void ofTest() {
        //如果把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException：
        Optional<String> optionalS = Optional.of( "df" );
        assertTrue(optionalS.isPresent());
        assertEquals("df",optionalS.get());
//        String s = optionalS.get();
//        System.out.println(s);
    }


    public static void ofNullableTest() {
        //如果对象即可能是 null 也可能是非 null，你就应该使用 ofNullable() 方法：
        Optional optional = Optional.ofNullable( null );
        System.out.println(optional.isPresent());
    }

    public static void df01() {
        /**
         * orElseGet() —— 其行为略有不同。这个方法会在有值的时候返回值，
         * 如果没有值，它会执行作为参数传入的 Supplier(供应者) 函数式接口，并将返回其执行结果：
         */
        Object o = Optional.ofNullable( "dd" ).orElseGet( () ->"ffff" );
        System.out.println(o);
    }

    public static void df02() {
        //除了 orElse() 和 orElseGet() 方法，Optional 还定义了 orElseThrow() API —— 它会在对象为空的时候抛出异常，而不是返回备选的值
        Object o = Optional.ofNullable( "ddd" ).orElseThrow(()-> new IllegalArgumentException());
        System.out.println(o);
    }


    /**
     * orElse 方法表示当容器为null是显示orElse里面的内容
     */
    public static void orElse1() {
       String s =  Optional.of( "df" ).orElse( "dff" );
       System.out.println("dff");
    }


    /**
     *orElseGet() —— 其行为略有不同。这个方法会在有值的时候返回值，
     */
    public static void orGetElse02() {
        String s = Optional.of( "ff" ).orElseGet( () ->"dd");
        System.out.println(s);
    }


    /**
     *转换值
     */
    public static void df03() {
        User user = null;
        for(int i = 0;i<10;++i) {
            user = new User( i+"",i );
            System.out.println(user);
        }
       Object o =  Optional.ofNullable( user )
               .map( u->u.getName() )
               .orElse( "dfff" )
               ;
        System.out.println(o);
    }

    public static void df04() {
        User user = null;
        for(int i = 0;i<10;++i) {
            user = new User( i+"",i );
        }
//        user.setName("Developer");
//        user.setId( 454 );
        Object o = Optional.ofNullable( user )
                .flatMap( u -> u.getOptional())
                .orElse( "dffr" );
        System.out.println(o);
    }


    /**
     * 过滤值
     *
     * 除了转换值之外，Optional  类也提供了按条件“过滤”值的方法。

     filter() 接受一个 Predicate 参数，返回测试结果为 true 的值。如果测试结果为 false，会返回一个空的 Optional。
     */
    public static void df05() {
        User u = new User( "xiaohua",123 );
        Optional optional = Optional.ofNullable( u )
                .filter( uu -> uu.getName() != null && u.getName().contains( "zx" ) );
        System.out.println(optional.isPresent());
    }


    /**
     * Optional 类的链式方法
     */
    public static void df06() {

        User u = User.builder().id( 12 )
                .name( "sd" )
                .build();
        System.out.println(u);

    }


    /**
     * 常规升排序
     */
    public static void sortTest() {
        List<User> list = new ArrayList <>(  );
        list.add( new User( "a",1 ) );
        list.add( new User( "f",6 ) );
        list.add( new User( "d",7 ) );
        list.add( new User( "f",0 ) );
        list.add( new User( "q",12 ) );


        //按照id排序
        Collections.sort( list, new Comparator <User>( ) {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
                //o2.getId() - o1.getId()  降序
                //o1.getId() - o2.getId()  升序
            }
        } );


        //按照name排序。只需要重写匿名内部类就可以
        Collections.sort( list, new Comparator <User>( ) {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo( o2.getName() );
                //o1.getName().compareTo( o2.getName() );
                //o2.getName().compareTo( o1.getName() )
            }
        } );

        //遍历结果，是否排序
        for (User u :list) {
            System.out.println(u);
        }


        /**
         * 升序  Collections.sort(list)
         * 降序  Collections.reserve(list)
         * 随机  Collections.shuffle(list)
         */

    }


    /**
     * Lambda排序
     *  /**
     * 升序  Collections.sort(list)
     * 降序  Collections.reserve(list)
     * 随机  Collections.shuffle(list)
     */
    public static void lambdaTest() {
       List<User> list = getList();

        //排序    降序
        list.sort((o1, o2) -> o2.getId() - o1.getId());

        //排序    升序
        list.sort((o1, o2) -> o1.getId() - o2.getId());

        //遍历
        list.forEach( System.out::println);
    }


    /**
     * 多条件组合排序
     *  /**
     * 升序  Collections.sort(list)
     * 降序  Collections.reserve(list)
     * 随机  Collections.shuffle(list)
     */
    public static void lambdaTest02() {
        List<User> list = getList();

        list.sort(Comparator
                .comparing(User::getId).reversed()
                .thenComparing(User::getName).reversed()
        );
        list.forEach( user ->System.out.println(user));



    }

    /**
     * 获取list
     * @return
     */
    public static List<User> getList() {
        List<User> list = new ArrayList <>(  );
        list.add( new User( "a",1 ) );
        list.add( new User( "f",6 ) );
        list.add( new User( "d",7 ) );
        list.add( new User( "k",0 ) );
        list.add( new User( "d",56 ) );
        list.add( new User( "g",125 ) );
        list.add( new User( "u",25 ) );
        list.add( new User( "y",87 ) );
        list.add( new User( "t",53));
        list.add( new User( "r",123 ) );
        list.add( new User( "e",987 ) );
        list.add( new User( "q",4 ) );
        return list;
    }
























}
