package com.example.redisdemo.controller;
import com.example.redisdemo.entity.UserEntity;
import com.example.redisdemo.pojo.User;
import com.example.redisdemo.request.RequestMode;
import com.example.redisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    Logger logger = LoggerFactory.getLogger( UserService.class );

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping(value = "/all")
    @ResponseBody
    public List<UserEntity> list() {
        return userService.findAll( 9L );
    }

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

    /**
     * 查询用户列表
     * @return
     */
    @PostMapping(value = "find")
    @ResponseBody
    public UserEntity listjj(@RequestBody(required = false) RequestMode requestMode) {
        return userService.finaUserByNAME1(requestMode.getName());
    }

    /**
     * 添加用户
     * @return
     */
    @PostMapping(value = "add")
    @ResponseBody
    public UserEntity add() {
        UserEntity userEntity = new UserEntity( );
        userEntity.setAddress( "测试1" );
        userEntity.setName( "测试2" );
        userEntity.setSex( 77 );
        System.out.println(userEntity);
        return userService.add(userEntity);
    }


    /**
     * 删除用户
     * @return
     */
    @PostMapping(value = "delete")
    @ResponseBody
    public Boolean delete() {
       return userService.delete(18  );
    }





}
