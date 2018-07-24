package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/7/
 */
@Repository
public interface UserRepository extends BaseRepository<UserEntity,Long> {

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    UserEntity findByUsername(String name);
}
