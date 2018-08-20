package com.example.springtest.bean;

import com.example.springtest.demo.StudentService;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class FactoryBeanApi {
    public StudentService newIntance(String message) {
        return new StudentService( message );
    }
}
