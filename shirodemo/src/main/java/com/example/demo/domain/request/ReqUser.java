package com.example.demo.domain.request;
import lombok.Data;

import javax.persistence.PrePersist;


/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Data
public class ReqUser {

    private Long id;

    private String username;

    private String password;

    private Boolean isRememberMe;


    @PrePersist
    protected void onCreate() {
        isRememberMe = true;
    }

}
