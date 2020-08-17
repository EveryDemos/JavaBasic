package com.budi.thredcommunication;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-02-21-30
 **/
public class MainOddEvenTest {
    public static void main(String[] args) {
        final ThredOddAndEven oddAndEven = new ThredOddAndEven();
        Thread thread=new Thread(new Runnable() {
            public void run() {
                oddAndEven.Odd();
            }
        });
        Thread thread2=new Thread(new Runnable() {
            public void run() {
                oddAndEven.even();
            }
        });
        thread.start();
        thread2.start();
    }
}
