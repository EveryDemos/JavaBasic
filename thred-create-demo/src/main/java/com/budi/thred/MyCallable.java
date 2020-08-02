package com.budi.thred;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-01-22-12
 **/
public class MyCallable implements Callable<String> {
    /**
     *
     * @return
     * @throws Exception
     */
    public String call() throws Exception {

        for (int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" 执行时间："+new Date().getTime());
        }
        return "";
    }

    public static void main(String[] args) {

        try {
            FutureTask task = new FutureTask<String>(new MyCallable());
            Thread thread = new Thread(task);
            thread.start();
            Object o = task.get();

            System.out.println("执行结果"+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
