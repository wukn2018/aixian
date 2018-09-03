package com.example.springtest.pojo;

import java.util.HashMap;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 *
 * 实例工厂方法 : 即需要创建工厂本身，再工厂的实例方法，在返回bean的实例
 */
public class InatanceCarFactory {

    private static HashMap<String,Car> map = null;

    public InatanceCarFactory() {
        map = new HashMap<String,Car>();
        map.put( "a",new Car( "a",100 ) );
        map.put( "b",new Car( "b",200 ) );
    }

    public Car getCar(String name) {
        return map.get( name );
    }







}
