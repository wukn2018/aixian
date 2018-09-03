package com.example.springtest.web.controller;

import com.example.springtest.entity.UserEntity;
import com.example.springtest.pojo.User;
import com.example.springtest.service.UserJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@RestController
@RequestMapping(value = "user")
public class UserController {



    @Autowired
    private UserJpaService userService;




    /**
     * 查询
     * @param
     * @param
     * @return
     */
    @PostMapping(value = "/nameandsex")
    @ResponseBody
    public UserEntity findUserByName(@Valid @RequestBody(required = false) User user) throws Exception{
        return userService.finaUserByNAME( user.getName(),user.getSex() );
    }

















}
