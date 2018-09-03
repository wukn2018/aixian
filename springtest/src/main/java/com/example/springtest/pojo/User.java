package com.example.springtest.pojo;

import lombok.Data;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Data
public class User {
    /**
    *name
    */
    private String name;

    /**
     * id
     */
    private Integer sex;


    public User() {
    }

    public User(String name, Integer sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
