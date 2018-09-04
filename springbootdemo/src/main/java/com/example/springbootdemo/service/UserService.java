package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Service
public class UserService {


    @Autowired
    private UserRepository userJpa;

    Logger logger = LoggerFactory.getLogger( UserService.class );




    /**1
     *根据name和id查询
     * 使用propagation 指定事务的传播行为，即当前的事物方法被另外一个事物方法调用时如何使用事物
     * 默认取值  REQUIRED : 使用调用方法原有的事物
     *          REQUIRES_NEW ： 使用新的事物，调用方法的事物被挂起
     *
     *2
     * isolation: 指定事务的隔离级别
     * 最常用的取值  isolation = Isolation.READ_COMMITTED  读已提交
     *
     * 默认情况下spring的申明事事务对所有的运行时异常进行回滚也可以通过对应的属性设置
     *noRollbackFor  对哪些异常不进行回滚
     * rollbackFor  对那些异常进行回滚
     * 通过情况下取默认值
     *
     *
     *3
     * 使用readOnly指定事务为只读
     *
     *
     *4
     *timeout = 1  设置事务的链接时间
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public UserEntity finaUserByNAME(String name , int sex) throws Exception{
        return userJpa.findUserEntityByNameAndSex( name,sex );
    }

































}
