package com.example.jedis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 *
 * @Author : Wukn
 * @Date : 2018/2/5
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {



    @Test
    public void dfs() throws Exception{
        int arr[] = new int[1000];
        Random random = new Random();
        int total = 0;
        // 初始化100个数字元素
        for (int i = 0; i < arr.length; i++) {
            int temp = random.nextInt(100);
            // 对数组元素赋值,并将数组元素的值添加到total总和中
            total += (arr[i] = temp);
        }
        System.out.println("初始化时的总和=" + total);

        // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 提交可分解的PrintTask任务
//        Future<Integer> future = forkJoinPool.submit(new RecursiveTaskDemo(arr, 0, arr.length));
//        System.out.println("计算出来的总和="+future.get());


        Integer integer = forkJoinPool.invoke( new RecursiveTaskDemo(arr, 0, arr.length)  );
        System.out.println("计算出来的总和=" + integer);

        // 关闭线程池
        forkJoinPool.shutdown();
    }













    @Test
    public void gh() throws Exception{
        // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 提交可分解的PrintTask任务
        forkJoinPool.submit(new RaskDemo(0, 1000));

        //阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);

        // 关闭线程池
        forkJoinPool.shutdown();
    }


    @Test
    public void fgfg() {
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        boolean b = false;
        int i = 0;
        try {
            Date nowDate = df.parse(df.format(new Date()));
            Date start = df.parse( "2018-03-26 14:46:15" );
            Date end = df.parse( "2018-04-30 14:46:20" );

            if(i < nowDate.compareTo( start ) && i > nowDate.compareTo( end ) ) {
                b = true;
            }
        } catch (Exception e) {
            e.printStackTrace( );
        }
       System.out.println(b);
    }




    @Test
    public void istfhTes() {
        List<Integer> list = new ArrayList<>(  );
        list.add( 1 );
        list.add( 8 );
        list.add( 0 );
        list.add( 9 );
        list.add( 100 );
        list.add(99 );
        list.add( 66 );
        list.add( 12 );

        //获取最小值
        Integer i = Collections.min(list);
        System.out.println("最小值"+i);
        Integer j = Collections.max(list);
        System.out.println("最大值"+j);




//        System.out.println(i);
//        String a = "";
//        User user = new User(  );
//        user.setName( "" );
//        user.setId( 1 );
//
//        User user1 = new User(  );
//        user1.setId( user.getId() );
//        user1.setName( user.getName() );
//        System.out.println(user);

    }

}
