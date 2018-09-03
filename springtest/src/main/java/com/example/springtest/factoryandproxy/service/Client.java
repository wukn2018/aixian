package com.example.springtest.factoryandproxy.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class Client {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner( System.in );
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入参数：");
            Integer a = scanner.nextInt();
            System.out.println("请输入符号：");
            String b = br.readLine();
            System.out.println("请输入参数：");
            Integer c = scanner.nextInt();
        }catch (Exception e) {
            System.out.println("你输入的参数有误");
        }
    }
}
