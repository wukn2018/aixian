package com.example.demo.web;

import com.example.demo.domain.request.ReqUser;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.util.BCryptUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/7/
 */
@RestController
public class LoginController {

    Logger logger = LoggerFactory.getLogger( LoginController.class );

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptUtils bCryptUtils;


    /**
     * 登录
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody ReqUser reqUser) {
        logger.info( "ReqUser"+reqUser );
        String error = null;
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken( reqUser.getUsername(), reqUser.getPassword());
        token.setRememberMe( true );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            error = "其他错误：" + e.getMessage();
        }
        //出错了，返回登录页面
        if(error != null) {
            return "lohin fail";
        }
        return "login success";
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



    @RequestMapping(value = "/test")
    public String testd(@RequestBody ReqUser reqUser) {
        return "success";
    }


























}
