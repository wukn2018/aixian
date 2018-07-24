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
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roleName;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
    private List<PermissionEntity> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List <PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List <PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return JSON.toJSONString( this );
    }
}
