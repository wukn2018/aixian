package com.example.demo.entity;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import java.util.List;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/7/
 */
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private Integer password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<RoleEntity> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public List <RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List <RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
}
