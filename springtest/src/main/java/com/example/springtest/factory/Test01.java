package com.example.springtest.factory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/8/20
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数字A：");
            int i = sc.nextInt();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请选择符号：+  -  *  /");
            String line = br.readLine();

            System.out.println("请输入数字B：");
            int j = sc.nextInt();


            //结果
            String result = "";
            switch (line) {
                case  "+":
                    result = String.valueOf( i+j );
                    break;
                case  "-":
                    result = String.valueOf( i-j );
                    break;
                case  "*":
                    result = String.valueOf( i*j );
                    break;
                case  "/":
                    if(j==0) {
                        result = "除数不能为0";
                    }
                    result = String.valueOf( i/j );
                    break;

            }

            System.out.println("结果是："+result);
        } catch (Exception e) {
            e.printStackTrace( );
        }


    }
}
