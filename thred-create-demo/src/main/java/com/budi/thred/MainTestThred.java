package com.budi.thred;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-02-15-08
 **/
public class MainTestThred {
    public static void main(String[] args) {
        //线程池的使用
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new MyRunable());
    }
}
