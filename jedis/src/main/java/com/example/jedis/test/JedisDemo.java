//package com.example.jedis.test;
//
//import com.example.jedis.dao.JedisDao;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//import java.util.List;
//
///**
// * com.xinguangnet.tuchao.merchant.manage
// *
// * @Author : Wukn
// * @Date : 2018/2/5
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class JedisDemo {
//
//
//    @Autowired
//    private JedisDao jedisDao;
//
//    /**
//     * jedis
//     */
//    @Test
//    public void fg() {
//        //创建和redis的连接
//        Jedis jedis = new Jedis( "127.0.0.1",6379 );
//        //存入
//        jedis.set( "key01","01" );
//
//        //取出
//        System.out.println(jedis.get( "key01" ));
//    }
//
//
//    /**
//     * jedisPool
//     */
//    @Test
//    public void poolTest() {
//        //创建连接池
//        JedisPool pool = new JedisPool("127.0.0.1",6379  );
//        //获取连接
//        Jedis jedis = pool.getResource();
//
//        jedis.set( "key02","02" );
//        System.out.println(jedis.get( "key02" ));
//        //关闭
//        jedis.close();
//
//
//    }
//
//
//    @Test
//    public void dfg() {
////        List<String> list = new ArrayList <>(  );
////        list.add( "1" );
////        list.add( "2" );
////        list.add( "3" );
////        list.add( "4" );
////        jedisDao.setList( "key05",list,5000 );
//        List<String> list = jedisDao.getList("key05");
//        for (String s:list) {
//            System.out.println(s);
//        }
//        System.out.println(list.size());
//
//        //System.out.println(jedisDao.listAdd( "key05","5" ));
//    }
//
//
//
//    public void getd() {
//        List<String> list = jedisDao.getList("key05");
//        System.out.println(list.size());
//    }
//
//
//    @Test
//    public void df() {
//        System.out.println("ssssssss");
//    }
//
//
//
//}
