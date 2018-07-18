package com.example.jedis.test;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @Author : Wukn
 * @Date : 2018/2/5
 */
public class RecursiveTaskDemo extends RecursiveTask<Integer> {

    /**
     *  每个"小任务"最多只打印70个数
     */
    private static final int MAX = 70;
    private int arr[];
    private int start;
    private int end;


    public RecursiveTaskDemo(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    public RecursiveTaskDemo(int start, int middle) {
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // 当end-start的值小于MAX时候，开始打印
        if((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
                System.out.println(sum+"-=-=-=-=");
            }
            return sum;
        }else {
            System.err.println("=====任务分解======");
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            RecursiveTaskDemo left = new RecursiveTaskDemo(arr, start, middle);
            RecursiveTaskDemo right = new RecursiveTaskDemo(arr, middle, end);
            // 并行执行两个小任务
            left.fork();
            right.fork();
            // 把两个小任务累加的结果合并起来
            return left.join() + right.join();
        }
    }












}
