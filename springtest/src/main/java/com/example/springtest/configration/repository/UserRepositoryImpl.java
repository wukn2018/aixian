package com.example.springtest.configration.repository;

import org.springframework.stereotype.Component;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 * @Component注解会被ioc识别，并且在@Component中可以指定bean的名称，要是不指定会默认是类名，但是第一个字母是小写
 */
@Component
public class UserRepositoryImpl implements UserRepository{
    @Override
    public void addU() {
        System.out.println("eee11111111");
    }
}
