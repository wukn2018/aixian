package com.example.springtest.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 *
 * 静态工厂方法： 直接调用某一个类的静态方法就可以返回Bean的实例
 */
public class BeanFactoryDome {

    private static Map<String ,Car>  map = new HashMap <>(  );

    static {
        map.put( "a",new Car( "a",100 ) );
        map.put( "b",new Car( "b",200 ) );
    }


    public static Car getCar(String name) {
        return map.get( name );
    }

}
