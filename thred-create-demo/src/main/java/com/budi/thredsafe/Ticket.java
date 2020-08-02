package com.budi.thredsafe;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-02-15-38
 **/
public class Ticket implements Runnable {
   private Object o= new Object();
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
                saleTicket();
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
