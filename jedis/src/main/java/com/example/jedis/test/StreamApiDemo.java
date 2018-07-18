package com.example.jedis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */

/**
 * StreamApi
 *
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StreamApiDemo {

    /**
     * Stream三个操作步骤
     * 1,创建Stream
     * 2,中间操作
     * 3,中止操作
     */

/***********************************************    Stream流的创建     ***************************************************************/


    /**
     *  创建Stream流的方式
     */
    @Test
    public void test1() {

       /**可以通过Collection 集合系列提供的
        * stream()   串行流
        * 或
        * parallelStream()  并行流
        */
        List<String> list = new ArrayList <>(  );
        Stream<String> stream = list.stream();



        /**
         *通过Arrays中的静态方法stream()获取数组流
         */
        Use[] uses = new Use[10];
        Stream<Use> stream1 = Arrays.stream( uses );



        /**
         * 通过Stream类中的静态方法  of()
         */
        Stream<String> stream2 = Stream.of( "aa" );



        /**
         * 创建无限流
         */
        //迭代
        Stream<Integer> stream3 = Stream.iterate( 0,(x) -> x+2 );
        stream3.limit( 10 ).forEach( (x) -> System.out.println(x));


        //生成
        Stream.generate( () -> Math.random() )     //数据源,可以产生任意的随机数
                .limit( 5 )                       //中间操作,只需要五个随机数
                .forEach( System.out::println );   //中止操作,遍历打印这五个
    }


    /***********************************************    Stream流的中间操作     ***************************************************************/


    /**
     * Stream流的中间操作
     */


    /**
     * 筛选与切片
     *
     * filter - 接受Lambda,从流中排除某些元素
     * limit - 截断流,使其元素不超过给定数量
     * skip(n) - 跳过元素,返回一个扔掉了前n个元素的流,若流中元素不足n个,则返回一个空流,与limit互补
     * distinct - 筛选,通过流所生产元素的hashCode() 和 equals() 去除重复元素
     */
    final List<Use> list = Arrays.asList(
            new Use( "a",1,3 ),
            new Use( "e",5,4 ),
            new Use( "c",2,5 ),
            new Use( "b",4,2 ),
            new Use( "e",3,1 ));

    //内部迭代
    @Test
    public void test2() {

        /**
         * 中间操作不会单独执行.只有执行中止操作才会去执行中间,
         */
                //创建Stream对象
       Stream stream =  list.stream()
               //中间操作
                /** filter里面是一个断言型接口,传入一个参数,返回一个boolean值  filter - 接受Lambda,从流中排除某些元素*/
                .filter( (x) -> x.getId()>1);
                //中止操作
                stream.forEach( System.out::println );

    }

    @Test
    public void test4() {
        list.stream()
                .filter( (x) -> x.getSaler()>2 )
                /**只需要找到满足条件之后,就不会去继续迭代其他,提高了效率,  limit - 截断流,使其元素不超过给定数量*/
                .limit( 2 )
                .forEach( System.out::println );
    }


    @Test
    public void test5() {
        list.stream()
                .filter( (x) -> x.getId()>0 )
                .limit(3 )
                /**skip(n) - 跳过元素,返回一个扔掉了前n个元素的流,若流中元素不足n个,则返回一个空流,与limit互补*/
                .skip( 2 )
                .forEach( System.out::println );
    }


    @Test
    public void test6() {
        list.stream()
                .filter( (x) -> x.getId()>0 )
                .limit( 5 )
                .skip( 2 )
                /**distinct - 筛选,通过流所生产元素的hashCode() 和 equals() 去除重复元素  在使用此方式时一定要重写hashCode() 和 equals()*/
                .distinct()
                .forEach( System.out::println );
    }
    //外部迭代
    @Test
    public void test3() {
        Iterator<Use> stream = list.iterator();
        if(stream.hasNext()) {
            System.out.println(stream.next());
        }

    }




    /**
     * 映射
     *
     * map - 接收Lambda,将元素转化成其他形式或提取信息,接收一个函数作为参数,改元素会应用到每个元素上,
     * 并将其映射成一个新的元素,
     *
     * flatMap - 接收一个函数作为参数,将流中的的每个值都换成另一个流,然后把所有的流连接成一个流
     */

    @Test
    public void test7() {
        List<String> slist = Arrays.asList( "aa","bb","cc","dd","ee","ff","gg" );
        slist.stream()
                /**map 的作用是将集合中的每个属性放在函数中去执行,执行的结果作为一个新的流,最后在中止操作中打印出来*/
                .map( (x) -> x.toUpperCase() )
                .forEach( System.out::println );


                list.stream()
                        .map( Use::getSaler )
                        .forEach( System.out::println );



                //
              Stream<Stream<Character>>  ssss =  slist.stream()
                        .map( (x) -> getString( x ));

              ssss.forEach( (x) ->{
                  x.forEach( System.out::println );
              } );
    }


    @Test
    public void test8() {
        List<String> slist2 = Arrays.asList( "aa","bb","cc","dd","ee","ff","gg" );
        /**map是使一个流中,存在几个小的流,这样就形成了几个小的流.形成一个大的流,所有在遍历时先去遍历大的流.得到每个小的流后再去遍历这个小流*/
        Stream<Stream<Character>>  ssss =  slist2.stream()
                .map( (x) -> getString( x ));

        ssss.forEach( (x) ->{
            x.forEach( System.out::println );
        } );



        /**flatMap - 接收一个函数作为参数,将流中的的每个值都换成另一个流,然后把所有的流连接成一个流*/
        Stream<Character> stream = slist2.stream()
                .flatMap( (x) -> getString( x ) );

        stream.forEach( System.out::println );

    }

    public static Stream<Character> getString(String str) {
        List<Character> sslist = new ArrayList <>(  );
        for(Character c:str.toCharArray()) {
            sslist.add( c );
        }
        return sslist.stream();
    }




    /**
     * 排序
     *
     * sortrd - 自然排序
     *
     * sorted(Comparator con) - 定制排序
     */

    @Test
    public void test9() {
        List<String> slist2 = Arrays.asList( "bb","ff","cc","dd","aa","ee","gg" );
        slist2.stream()
                //自然排序
                .sorted()
                .forEach( System.out::println );


        list.stream()
                //定制排序
                .sorted((x,y) -> {
                    if(x.getId( ).equals( y.getId( ) )) {
                        return x.getSaler().compareTo( y.getSaler() );
                    }else {
                        return x.getId().compareTo( y.getId() );
                    }})
                .forEach( System.out::println );
                ;
    }








    /*************************************Stream流的中止操作******************************************************/


    /**
     * 查找与匹配
     *
     * allMatch - 检查是否匹配所有元素
     * anyMatch - 检查是否至少匹配一个元素
     * noneMatch - 检查是否没有匹配所有元素
     * findFirst - 返回第一个元素+
     * findAny - 返回当前流中的任意元素
     * count - 返回流中元素的总和
     * max - 返回流中的最大值
     * min - 返回流中的最小值
     */
    @Test
    public void test10() {
        boolean b = list.stream()
                /**检查是否匹配所有元素   就是检查对象中的元素是否都满足allMatch()里面的要求,是就返回true   反之 false*/
                .allMatch( (x) -> x.getId()>2 );
        System.out.println(b);

        boolean b1 = list.stream()
                /**检查是否至少匹配一个元素   就是检查对象中的元素是否至少有一个满足anyMatch()里面的要求,是就返回true   反之 false*/
                .allMatch( (x) -> x.getId()>0 );
        System.out.println(b1);

        boolean b2 = list.stream()
                /**检查是否没有匹配所有元素   就是检查对象中的元素是否有满足noneMatch()里面的要求,是就返回true   反之 false*/
                .allMatch( (x) -> x.getId()>0 );
        System.out.println(b2);


        Optional b3 = list.stream()
               /**先排序*/
                .sorted((x,y) -> Double.compare( y.getId(),x.getId() ))
                /**返回第一个元素*/
                .findFirst( );
        System.out.println(b3.get());


        Optional optional = list.stream()
                .filter( (x) -> x.getId()>4 )
                /**findAny - 返回当前流中的任意元素*/
                .findAny();
       System.out.println(optional.get());


       Long l = list.stream()
               .filter( (x) -> x.getId()>0 )
               /*** * count - 返回流中元素的总和*/
               .count();
       System.out.println(l);


       Optional optional2 = list.stream()
               /**max - 返回流中的最大值**/
               .max( (x,y) -> Double.compare( x.getId(),y.getId() ) );
       System.out.println(optional2.get());




        Optional optional3 = list.stream()
                /**min - 返回流中的最小值**/
                .max( (x,y) -> Double.compare( x.getId(),y.getId() ) );
        System.out.println(optional3.get());


        /**
         * 得到具体的最小id
         */
        Optional<Integer> o = list.stream()
                //首先通过映射,得到一个id流,这个流包含所有的id
                .map( (x) -> x.getId() )
                //从新建的流中得到
                .min( (x,y) -> Double.compare( x,y ) );
        System.out.println(o.get());

    }






    /** ************************************************规约*****************************************************/


    /**
     * 规约
     *
     * reduce(T identity ,BinaryOperator) / reduce  - 可以将流中元素冉福结合起来,得到一个值
     */
    @Test
    public void test11() {
        List<Integer> llist = Arrays.asList( 1,2,3,4,5,6,7,8 );

        //这种不可能为空
        Integer sun = llist.stream()
                //首先把0作为x  然后0+1得到1  然后把1作为x  然后1+2  逐渐结合
                .reduce( 0,(x,y) -> x+y );
        System.out.println(sun);



        //这种可能为空,因为没有起始值
       Optional<Integer> ss =  list.stream()
                .map((x) -> x.getId()  )
                .reduce((x,y) -> x+y);
       System.out.println(ss.get());
    }






    /** *****************************************************收集**********************************************************************/


    /**
     * 收集
     * collect - 将流转化为其他形式,接受一个Collector接口的实现,用于给Stream中元素做汇总的方法
     */
    @Test
    public void test12() {

        /**
         * Collector接口中方法的实现决定了如何对流执行收集操作,(如收集到List,Set,Map)
         * 但是Collectors实用类提供了很多静态方法,可以方便的创建常见收集器实例
         */
        List l = list.stream()
                .map( (x) -> x.getName() )
                /**将得到的name放在list*/
                .collect( Collectors.toList() );
        l.forEach( System.out::println );



        list.stream()
                .map( (x) -> x.getName() )
                /**将得到的name放在set*/
                .collect( Collectors.toSet() );


        list.stream()
                .map( (x) -> x.getName() )
                /**将得到的name放在HashSet*/
                .collect( Collectors.toCollection( HashSet::new ) );





         Long l1 = list.stream()
                         /***得到集合的总数*/
                        .collect( Collectors.counting() );
         System.out.println(l1);


        Double d = list.stream()
                        /**id的平均值*/
                         .collect( Collectors.averagingDouble( Use::getId) );



        Double d1 = list.stream()
                         /**id的总和*/
                         .collect( Collectors.summingDouble(  Use::getId ) );



        Optional optional =  list.stream()
                             /**id的最大值*/
                            .collect( Collectors.maxBy((x,y) -> Double.compare( x.getId(),y.getId() )  ) );

         System.out.println( optional.get() );

                            /**id的最小值*/
         Optional<Integer> oo = list.stream( )
                 .map( Use::getSaler ).min( Double::compare );
         System.out.println(oo.get());


        /**
         * 分组
         *
         * 按照id分组
         */
        Map <Integer, List <Use>> m = list.stream()
                .collect( Collectors.groupingBy( Use::getId ) );

        //遍历map
        for (Map.Entry map:m.entrySet()) {
            System.out.println(map.getKey());
            System.out.println(map.getValue());
        }
        System.out.println(m);


        /**
         * 组合分组
         * 满足条件一个区(true),不满足条件一个区(false)
         */
        Map<String, Map<Integer, List<Use>>> mapMap = list.stream()
              .collect( Collectors.groupingBy( Use::getName,Collectors.groupingBy( (e) -> e.getId() ) ) );


        /**
         * 分区
         */
        Map<Boolean, List<Use>> map =  list.stream()
                .collect( Collectors.partitioningBy( (e) -> e.getId()>3 ) );
        System.out.println(map);



        DoubleSummaryStatistics dd = list.stream()
                .collect( Collectors.summarizingDouble( (x) -> x.getId() ) );


        /**
         * 连接字符串
         */
        list.stream()
                .map( (x) -> x.getName() )
                .collect( Collectors.joining("z") );

    }







/**************************************  Stream Api 的练习操作  ******************************************************/






@Test
public void test01() {
    Optional<Integer> optionalInteger = list.stream()
            .map( (x) -> 1 )
            .reduce( Integer::sum );
    System.out.println(optionalInteger.get());


}





/**************************************  并行流 与 顺序流  ******************************************************/

    /**
     *并行流 与 顺序流
     */
    @Test
    public void test03() {

        Instant start = Instant.now();
        LongStream.rangeClosed( 0,110 )
                //并行流
                .parallel()
                .reduce( 0,Long::sum );




        LongStream.rangeClosed( 0,110 )
                //顺序流
                .sequential()
                .reduce( 0,Long::sum );


        Instant end = Instant.now();
        System.out.println("耗费时间"+ Duration.between( start,end ).toMillis());

    }





/******************************************************    Optional 用法  **************************************************************/


    /**
     *  Optional.of(T t) : 创建一个Optional实例
     *  Optional.empty() : 创建一个空的Optional实例
     *  Optional.ofNullable(T t) : 若t不为null 创建Optional实例,否则创建空实例
     *  isPresent() : 判断是否包含值
     *  orElse(T t) : 如果调用对象包含值,就返回该值,否则返回t
     *  orElseGet(Supplier s) : 如果对象调用对象包含值,返回该值,否则返回s获取的值
     *  map(Function f) : 如果有值对其处理,并返回处理后的Optional,否则返回Optional.empty()
     *  flatMap(Function f) : 与map类似,要求返回值必须是Optional
     */
    @Test
    public void test04() {
        /**Optional.of( new Use(  ) ) 里面的对象不能为空,如果为空就会报异常*/
        Optional<Use> optionalUse = Optional.of( new Use(  ) );
        Use use = optionalUse.get();
        System.out.println(use);
    }

    @Test
    public void test05() {
        /**Optional.empty(  ) 里面的对象可为空*/
        Optional optional = Optional.empty();
        System.out.println(optional.get());
    }

    @Test
    public void test06() {
        /** Optional.ofNullable( new Use(  ) ) 里面的对象不可为空 也可以不为空*/
        Optional optional = Optional.ofNullable( new Use(  ) );
        Optional optional1 = Optional.ofNullable( null );

        //判断是否有值
        if(optional1.isPresent()) {
            System.out.println(optional1.get());
        }
        optional1.orElse( "空" );


        Object optional2 = Optional.ofNullable( null )
                /**如果Optional.ofNullable( null )里面的参数为null,就执行orElse()*/
                .orElse( "没有值" );
        System.out.println(optional2);


        Object o = Optional.ofNullable( null )
                /**如果Optional.ofNullable( null )里面的参数为null,就执行orElseGet() */
                .orElseGet( () -> new Use(  ) );
        System.out.println(o);
    }




    @Test
    public void test07() {
       Optional<String> optionalS =  Optional.ofNullable( new Use( "a",1,2 ) )
               /**map里面有个消费型接口,传一个参数,返回一个属性*/
                .map((x)-> x.getName()  );
       System.out.println(optionalS.get());



       Optional<String> optionalS1 = Optional.ofNullable( new Use( "a",1,2 ) )
               /**flatMap传一个参数,返回的数据必须要用Optional包装,可以进一步防止空指针*/
               .flatMap( (x) -> Optional.of( x.getName() ) );
       System.out.println(optionalS1.get());
    }




































}
