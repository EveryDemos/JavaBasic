package com.budi.thredsafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-02-15-38
 **/
public class Ticket implements Runnable {
   private Object o= new Object();
   Lock lock=new ReentrantLock(true);//true表示公平锁，各线程拥有的执行权一样。false不是公平的，拥有独占权
    //初始化电影票
    private int ticket=100;
    public void run() {
        //同步机制1： 同步代码块
            while (true){
                /*synchronized (o){
                    if(ticket>0){
                        //有票休息100ms
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"售出票第"+ticket--+"张");
                    }
                }*/

                //同步机制2：同步方法
               // saleTicket();

                //同步机制3 同步锁

                lock.lock();
                try {
                    if(ticket>0){
                        //有票休息100ms
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"售出票第"+ticket--+"张");
                    }
                }finally {
                    lock.unlock();
                }
            }
    }
    private synchronized void saleTicket(){
        if(ticket>0){
            //有票休息100ms
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"售出票第"+ticket--+"张");
        }
    }

}
