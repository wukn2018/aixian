package com.example.springtest.service;

import com.example.springtest.pojo.User;
import org.springframework.stereotype.Service;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
@Service
public class UserService extends BaseService<User>{

    public void testa() {
        baseRepository.show();
    }
}
