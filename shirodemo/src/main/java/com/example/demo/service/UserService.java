package com.example.demo.service;
import com.example.demo.domain.request.ReqUser;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/7/
 */

public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    UserEntity findByUsername(String name);


    /**
     * 添加用户
     * @return
     */
    public UserEntity addUser(ReqUser reqUser);

    /**
     * 添加角色
     * @return
     */
    public RoleEntity addRole(ReqUser reqUser);

    /**
     *  查询用户通过用户名
     */
    public UserEntity findByName(String name);



}
