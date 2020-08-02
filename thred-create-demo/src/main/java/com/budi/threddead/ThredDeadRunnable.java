package com.budi.threddead;

/**
 * @program: javabasic
 * @description: 构建线程死锁
 * @author:zhaoyongquan
 * @create:2020-08-02-17-28
 **/
public class ThredDeadRunnable implements Runnable {
    public ThredDeadRunnable(int flag){};
    public int flag;//控制线程的走向
    //创建两个被争夺的线程资源
    Object obj1=new Object();
    Object obj12=new Object();
    public void run() {
        if(flag==1){
            synchronized (obj1){
                System.out.println(Thread.currentThread().getName()+"获取到了obj1,等待获取obj2");
                try {
                    //休息1秒，让另一个线程获取obj2
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            synchronized (obj12){
                System.out.println(Thread.currentThread().getName()+"获取到了obj1和obj2");
            }
        }
        if(flag==0){
            synchronized (obj12){
                System.out.println(Thread.currentThread().getName()+"获取到了obj12,等待获取obj1");
                try {
                    //休息1秒，让另一个线程获取obj1
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            synchronized (obj1){
                System.out.println(Thread.currentThread().getName()+"获取到了obj1和obj2");
            }
        }
    }
}
