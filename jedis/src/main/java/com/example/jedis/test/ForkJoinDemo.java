package com.example.jedis.test;

import java.util.concurrent.RecursiveTask;

/**
 * ***GOOD LUCK****
 *
 * @Author : Wukn
 * @Date : 2018/6/
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {


    private int start;
    private int end;

    private static final long END = 1000;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int i = end - start;
        int s = 0;
        /**
         * 先判断开始值到末位置值否达到临界值,如果小于临界值说明不用拆分了.直接求和,如果大于临界值继续拆分
         */
        if(i <= END) {
            for(int j= start;j<=end;++j) {
                s+=i;
            }
            return s;
        }else {
            int middle = (end - start)/2;
            ForkJoinDemo  left = new ForkJoinDemo (start, middle);
            left.fork();

            ForkJoinDemo  right = new ForkJoinDemo ( middle,end );
            right.fork();
            return left.join()+right.join();
        }
    }
}
