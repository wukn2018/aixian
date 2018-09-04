package com.example.jedis.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/1
 */
@Configuration
public class JedisConfig {

    Logger logger = LoggerFactory.getLogger( JedisConfig.class );


    /**
     * 端口号
     */
    @Value( "${jedis.port}" )
    private Integer port;


    /**
     * local
     */
    @Value( "${jedis.host}" )
    private String host;


    /**
     * 超时时间
     */
    @Value( "${jedis.max.timeout}" )
    private Integer timeout;






    @Bean
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        return poolConfig;
    }




    @Bean
    public JedisPool getJedisPool() {
        JedisPoolConfig config = getRedisConfig();
        JedisPool pool = new JedisPool(config,host,port,timeout);
        logger.info("init JredisPool ...");
        return pool;
    }



    @Bean
    public Jedis getJedis() {
        return getJedisPool().getResource();
    }













}
