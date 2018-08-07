package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     * @param username
     * @return
     */
    @Query(value = "select s from UserEntity s where s.username = :username")
    List<UserEntity>  findByUsername(@Param( "username" ) String username);


}
