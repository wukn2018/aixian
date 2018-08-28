package com.example.springtest.pojo;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class BeanTest {
    private String name;

    public BeanTest(String name) {
        this.name = name;
    }

    public BeanTest() {
        System.out.println("构造初始化。。。。。。。。。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        System.out.println("初始化。。。。");
    }

    public void destroy() {
        System.out.println("销毁。。。。。。");
    }
}
