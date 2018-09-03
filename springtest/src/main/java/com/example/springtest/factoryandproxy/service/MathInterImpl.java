package com.example.springtest.factoryandproxy.service;

import com.example.springtest.factoryandproxy.inter.MateInter;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class MathInterImpl implements MateInter {
    @Override
    public void add(Integer i) {
        System.out.println(i+"添加11111");
    }

    @Override
    public void delete(String str) {
        System.out.println(str+"删除2222222222");
    }
}
