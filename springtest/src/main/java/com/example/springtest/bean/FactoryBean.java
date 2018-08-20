package com.example.springtest.bean;

import com.example.springtest.demo.StudentService;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class FactoryBean {

    public static StudentService newInstance(String message) {
        return new StudentService( message );
    }
}
