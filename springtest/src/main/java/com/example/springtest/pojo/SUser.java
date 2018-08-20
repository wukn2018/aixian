package com.example.springtest.pojo;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class SUser {
    private String name;
    private Car car;
    private Address address;

    public SUser() {
    }

    public SUser(Car car, Address address) {
        this.car = car;
        this.address = address;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SUser{" +
                "car=" + car +
                ", address=" + address +
                '}';
    }
}
