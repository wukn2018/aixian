package com.example.springtest.service;

import com.example.springtest.service.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/9/2
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> baseRepository;

    public void add() {
        String s = baseRepository.show();
        System.out.println("泛型方法。。。。。"+s);
    }

}
