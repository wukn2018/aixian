package com.example.springbootdemo.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Data
public class User {
   
    private Long id;

    @NotBlank(message = "name不能为空")
    private String name;

    
    private Integer sex;

    
    private String address;
    
    
    
}
