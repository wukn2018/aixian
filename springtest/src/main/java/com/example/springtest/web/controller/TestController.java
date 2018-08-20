package com.example.springtest.web.controller;

import com.example.springtest.pojo.User;
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



    @PostMapping(value = "gets")
    @ResponseBody
    public String getStrinf(@RequestBody User user) {
        return user.getName()+ user.getId( );
    }
}
