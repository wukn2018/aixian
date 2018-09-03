package com.example.springtest.pojo;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class Car {
    private String carName;
    private double tper;


    public Car(String carName, double tper) {
        this.carName = carName;
        this.tper = tper;
    }

    public Car() {
        this.carName = "dddd";
    }

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getTper() {
        return tper;
    }

    public void setTper(double tper) {
        this.tper = tper;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", tper=" + tper +
                '}';
    }

    protected void onCreate() {
        carName = "sss";
    }
}
