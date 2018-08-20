package com.example.springtest.pojo;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class Address {
    private String name;
    private Integer id;

    public Address() {
    }

    public Address(String name, Integer id) {
        this.name = name;
        this.id = id;
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

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
