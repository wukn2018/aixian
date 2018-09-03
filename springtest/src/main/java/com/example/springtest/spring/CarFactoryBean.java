package com.example.springtest.spring;
import com.example.springtest.pojo.Car;
import org.springframework.beans.factory.FactoryBean;
/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 *
 * 自定义的FactoryBean需要实现FactoryBean接口
 */
public class CarFactoryBean implements FactoryBean{
    private String name;
    /**
     * 返回Bean的对象
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        return new Car( "c",110 );
    }
    /**
     * 返回bean的类型
     * @return
     */
    @Override
    public Class <?> getObjectType() {
        return Car.class;
    }
    @Override
    public boolean isSingleton() {
        return false;
    }
}
