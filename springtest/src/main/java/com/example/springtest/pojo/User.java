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
    private Integer id;


    public User(String name) {
        this.name = name;
    }

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
