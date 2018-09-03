package com.example.springtest.web.controller;

import com.example.springtest.AspectJDemo.service.MateInter;
import com.example.springtest.configration.repository.UserRepository;
import com.example.springtest.pojo.User;
import com.example.springtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    /**
     * 在ioc容器中，要是没有装配成功这个bean会有异常抛出，是设置了required = false就返回null
     *  @Qualifier("userRepositoryImpl")  会指定装配的bean
     *  也可以用set方法
     */
    @Autowired
    private UserRepository userRepository;



    @Autowired
    private UserService userService;



    @Autowired
    private MateInter mateInter;





    @PostMapping(value = "gets")
    @ResponseBody
    public String getStrinf(@RequestBody User user) {
        mateInter.add( 1 );
        return "ok";
    }























}
