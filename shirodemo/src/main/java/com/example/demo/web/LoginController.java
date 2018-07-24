package com.example.demo.web;

import com.example.demo.domain.request.ReqUser;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/7/
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {


    @Autowired
    private UserService userService;


    /**
     * 登录
     * @return
     */

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody ReqUser reqUser) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken( reqUser.getUsername(), reqUser.getPassword().toString());
        //进行验证，这里可以捕获异常，然后返回对应信息
        subject.login(usernamePasswordToken);
        return "login";
    }


    /**
     * 添加用户信息
     * @param reqUser
     * @return
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public String adduser(@RequestBody ReqUser reqUser) {
       UserEntity userEntity =  userService.addUser( reqUser );
       if(userEntity != null) {
           return "ok";
       }
       return "fail";
    }


























}
