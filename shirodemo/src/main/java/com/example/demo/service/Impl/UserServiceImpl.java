package com.example.demo.service.Impl;

import com.example.demo.domain.request.ReqUser;
import com.example.demo.entity.PermissionEntity;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.BCryptUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptUtils bCryptUtils;


    /**
     * 根据用户名查找
     * @param name
     * @return
     */
    @Override
    public UserEntity findByUsername(String name) {
        List<UserEntity> userEntity = userRepository.findByUsername( name );
        System.out.println(userEntity.get(0));
       return userEntity.get(  0);
    }


    /**
     * 添加用户
     * @return
     */
    @Override
    public UserEntity addUser(ReqUser reqUser) {
        UserEntity userEntity = new UserEntity();
        String s = bCryptUtils.getBCrypt( reqUser.getPassword().toString() );
        userEntity.setUsername( reqUser.getUsername());
        userEntity.setPassword(s);
       UserEntity userEntity1 =  userRepository.save( userEntity );
       return userEntity1;
    }


    /**
     * 添加角色
     * @return
     */
    @Override
    public RoleEntity addRole(ReqUser reqUser) {
        List<UserEntity> userEntity = userRepository.findByUsername( reqUser.getUsername() );
        RoleEntity role = new RoleEntity();
        role.setRoleName(reqUser.getUsername());
        role.setUser(userEntity.get( 0 ));

        PermissionEntity permission1 = new PermissionEntity();
        permission1.setPermission("create");
        permission1.setRole(role);

        PermissionEntity permission2 = new PermissionEntity();
        permission2.setPermission("update");
        permission2.setRole(role);

        List<PermissionEntity> permissions = new ArrayList<PermissionEntity>();
        permissions.add(permission1);
        permissions.add(permission2);

        role.setPermissions(permissions);
        roleRepository.save(role);
        return role;

    }


    /**
     *  查询用户通过用户名
     */
    @Override
    public UserEntity findByName(String name) {
        return userRepository.findByUsername(name).get(  0);
    }


















}
