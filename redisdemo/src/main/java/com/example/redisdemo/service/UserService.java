package com.example.redisdemo.service;
import com.example.redisdemo.entity.UserEntity;
import com.example.redisdemo.repository.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author : Wukn
 * @Date : 2018/2/5
 */
@Service
public class UserService {

    @Autowired
    private UserJpa userJpa;

    Logger logger = LoggerFactory.getLogger( UserService.class );



//    @Autowired
//    private RedisTemplate redisTemplate;
//
//
//
//    @Autowired
//    private CacheManager cacheManager;
//




    /**
     *
     * @return
//     */
//    @Transactional(readOnly = true)
//    @Cacheable(value = "ert",key = "#id")
    public List <UserEntity> findAll(Long id) {
       return userJpa.findAll();
    }


    /**
     *根据name和id查询
     * @param name
     * @param sex
     * @return
     *
     * @Cacheable 应用到读取数据的方法上，
     * 先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     * value 非必填。用于注定缓存数据的储存集合名称
     * unless 表示条件表达式成立的话不放入缓存
     */
    @Cacheable(value = "user", key = "#sex + #name", unless = "#result eq null")
    public UserEntity finaUserByNAME(String name , int sex) {
        return userJpa.findUserEntityByNameAndSex( name,sex );
    }


    /**
     * 新增用户
     * @param userEntity
     * @return
     * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     */
    @CachePut(value = "user",key = "#userEntity.getName()+'add'")
    public UserEntity add(UserEntity userEntity) {
        System.out.println(userEntity);
        return userJpa.save( userEntity );
    }

    /**
     *删除
     * @return
     * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
     * 会删除名称为“user”的集合对象
     */
    @CacheEvict(value = "user", key = "'66redis'", condition = "#result eq true")
    public boolean delete(Integer id) {
        return userJpa.deleteUser( id )>0;
    }


    /**
     *根据name和id查询
     * @param name
     * @param
     * @return
     */
    public UserEntity finaUserByNAME1(String name ) {
        return userJpa.findUserEntityByName( name);
    }







}
