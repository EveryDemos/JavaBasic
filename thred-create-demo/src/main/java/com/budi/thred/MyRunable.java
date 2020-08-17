package com.budi.thred;

import java.util.Date;

/**
 * @program: javabasic
 * @description: 线程池用到
 * @author:zhaoyongquan
 * @create:2020-08-02-15-07
 **/
public class MyRunable implements Runnable{
    public void run() {
        for (int i = 0; i <=1 ; i++) {
            System.out.println(Thread.currentThread().getName()+"执行时间："+new Date().getTime()+" 执行次数："+i);
        }
    }
}
