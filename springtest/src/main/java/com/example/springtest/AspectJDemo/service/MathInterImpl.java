package com.example.springtest.AspectJDemo.service;

import org.springframework.stereotype.Component;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Component
public class MathInterImpl implements MateInter {

    @Override
    public void add(Integer i) {
        System.out.println("添加方法{}------>"+i);
    }

    @Override
    public void delete(String str) {
        System.out.println("删除方法{}------>"+str);
    }


}
