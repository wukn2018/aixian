package com.example.jedis.bean;

import com.alibaba.fastjson.JSON;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @Author : Wukn
 * @Date : 2018/6/12
 */
public class Student {




    @NotBlank(message="用户名不能为空")
    private String name;

    @Size(min=1,max=10,message="密码的长度应该在1和10之间")
    private String password;

    private Integer id;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
}
