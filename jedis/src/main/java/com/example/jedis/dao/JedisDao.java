package com.example.jedis.dao;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

import static jdk.nashorn.internal.runtime.JSType.toObject;


/**
 *
 * @Author : Wukn
 * @Date : 2018/6/1
 * https://blog.csdn.net/pengyu432/article/details/73467118
 * jedis工具类
 */
@Component
public class JedisDao {

    Logger logger = LoggerFactory.getLogger( JedisDao.class );




    @Autowired
    private Jedis jedis;

    @Autowired
    private JedisPool jedisPool;



    /**
     * 获取缓存
     * @param key 键
     * @return 值
     */
    public String get(String key) {
        logger.info( "key{}"+key );
        String value = null;
        try {
            if (existsKey(key)) {
                value = jedis.get(key);
                value = !StringUtils.isEmpty( value ) && !"nil".equalsIgnoreCase(value) ? value : null;
                logger.debug("get {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("get {} = {}", key, value, e);
        } finally {
            returnResource();
        }
        return value;
    }


    /**
     * 设置缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public String set(String key, String value, int cacheSeconds) {
        String result = null;
        try {
            result = jedis.set(key, value);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("set {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("set {} = {}", key, value, e);
        } finally {
            returnResource();
        }
        return result;
    }


    /**
     * 获取List缓存
     * @param key 键
     * @return 值
     */
    public  List<String> getList(String key) {
        List<String> value = null;
        try {
            if (existsKey(key)) {
                value = jedis.lrange(key, 0, -1);
                logger.debug("getList {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getList {} = {}", key, value, e);
        } finally {
            returnResource();
        }
        return value;
    }



    /**
     * 获取List缓存
     * @param key 键
     * @return 值
     */
    public  List<Object> getObjectList(String key) {
        List<Object> value = null;
        try {
            if (existsKey(key)) {
                List<byte[]> list = jedis.lrange(getBytesKey(key), 0, -1);
                value = Lists.newArrayList();
                for (byte[] bs : list){
                    value.add(toObject(bs));
                }
                logger.debug("getObjectList {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectList {} = {}", key, value, e);
        } finally {
            returnResource();
        }
        return value;
    }



    /**
     * 设置List缓存
     * @param key 键
     * @param value 值
     * @param cacheSeconds 超时时间，0为不超时
     * @return
     */
    public  long setList(String key, List<String> value, int cacheSeconds) {
        long result = 0;
        try {
            if (existsKey(key)) {
                jedis.del(key);
            }
            result = jedis.rpush(key, JSON.toJSONString( value ));
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
            logger.debug("setList {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setList {} = {}", key, value, e);
        } finally {
            returnResource();
        }
        return result;
    }




    /**
     * 向List缓存中添加值
     * @param key 键
     * @param value 值
     * @return
     */
    public  long listAdd(String key, String... value) {
        long result = 0;
        try {
            result = jedis.rpush(key, value);
            logger.debug("listAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("listAdd {} = {}", key, value, e.getMessage());
        } finally {
            returnResource();
        }
        return result;
    }

















    /**
     * 获取byte[]类型Key
     * @param
     * @return
     */
    public byte[] getBytesKey(Object object){
        if(object instanceof String){
            return ((String) object).getBytes();
        }else{
            return null;
        }
    }

    /**
     * 判断key是否存在
     * @return
     */
    public Boolean existsKey(String key) {
        Boolean b = false;
        logger.info( "key{}"+key );
        if(!StringUtils.isEmpty( key )) {
            b = jedis.exists( key );
            logger.info( "判断key是否存在b{}"+b );
           return b;
        }
        return b;
    }


    /**
     * 释放资源
     * @param
     * @param
     */
    public  void returnResource() {
        logger.info( "jedis连接池开始释放资源......" );
        try {
            jedisPool.returnResource(jedis);
        } catch (Exception e) {
            logger.info( "释放异常信息{}"+e.getMessage() );
        }
    }



































































}
