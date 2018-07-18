package com.example.jedis.test;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

/**
 *
 * @Author : Wukn
 * @Date : 2018/2/5
 */
@Data
@Builder
public class User {
    private String name;
    private Integer id;

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public Optional<String> getOptional() {
        return Optional.ofNullable( name );
    }



}
