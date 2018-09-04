package com.example.springbootdemo.web.controller;

import com.example.springbootdemo.commons.ClientResult;
import com.example.springbootdemo.commons.exception.CMSException;
import com.example.springbootdemo.entity.UserEntity;
import com.example.springbootdemo.pojo.User;
import com.example.springbootdemo.response.BaseResponse;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
    private UserService userService;




    /**
     * 查询
     * @param
     * @param
     * @return
     */
    @PostMapping(value = "/nameandsex")
    @ResponseBody
    public ClientResult findUserByName(@Valid @RequestBody(required = false) User user, BindingResult bindingResult)
            throws Exception{
        try {
            return new ClientResult( userService.finaUserByNAME( user.getName(),user.getSex() ) );
        } catch (CMSException e) {
            return new ClientResult( e.getCode(),e.getMsg());
        }

    }

















}
