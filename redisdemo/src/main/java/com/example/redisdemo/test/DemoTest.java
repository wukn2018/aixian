package com.example.redisdemo.test;

import com.alibaba.fastjson.JSON;
import com.example.redisdemo.pojo.User;
import com.example.redisdemo.utils.RedisDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**

 * @Author : Wukn
 * @Date : 2018/5/25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisDao redisDao;


    @Test
    public  void tedfh() {
        User user = new User();
        user.setSex( 55 );
        user.setName( "df" );
        String str = JSON.toJSONString( user );
       redisDao.set( "w06" ,str);
    }



    @Test
    public void deleteValue() throws Exception{
        redisDao.get("w03");
        System.out.println(  redisDao.get("w03")+"");
    }











}
