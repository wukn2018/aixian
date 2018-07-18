package com.example.jedis.test.bean;

import com.example.jedis.test.Use;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/25
 */
public interface FilterUser<T> {

    /**
     * 要想对Use这个对象的属性进行过滤，可以实现这个接口。这种设计模式成为策略模式
     * @param o
     * @return
     */
    public Boolean checkUser(Use o);
}
