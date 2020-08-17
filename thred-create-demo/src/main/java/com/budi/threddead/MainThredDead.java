package com.budi.threddead;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-02-17-27
 **/
public class MainThredDead {
    public static void main(String[] args) {
        ThredDeadRunnable deadRunnable = new ThredDeadRunnable(1);
        ThredDeadRunnable deadRunnable2 = new ThredDeadRunnable(0);

        Thread thread = new Thread(deadRunnable,"线程1");
        Thread thread2 = new Thread(deadRunnable2,"线程2");

        thread.start();
        thread2.start();
    }
}
