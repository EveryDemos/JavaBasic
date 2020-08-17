package com.budi.thredcommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-02-21-20
 **/
public class ThredOddAndEven {
    private int i=0;//要打印的数值

    /**
     * 以下是使用Objec实现等待和唤醒
     *//*


    private Object o=new Object();//object线程通讯方式

    *//**
     * 奇数打印方法线程
     *//*
    public void Odd(){
        while (i<10){
            synchronized (o){
                if(i%2==1){
                    System.out.println("打印奇数："+i);
                    i++;
                    o.notify();//唤醒偶数线程方法打印
                }else{
                    try {
                        o.wait();//等待偶数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
    *//**
     * 偶数线程打印方式
     *//*
    public void even(){
        while (i<10){
            synchronized (o){
                if(i%2==0){
                    System.out.println("打印偶数数："+i);
                    i++;
                    o.notify();//唤醒奇数线程方法打印
                }else{
                    try {
                        o.wait();//等待奇数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }*/


    /**
     * 以下是使用condition实现线程通讯 等待唤醒
     */

    /**
     * 奇数打印方法线程
     */
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void Odd(){
        while (i<10){
            lock.lock();
            try{
                if(i%2==1){
                    System.out.println("打印奇数："+i);
                    i++;
                    condition.signal();//唤醒偶数线程方法打印
                }else{
                    try {
                        condition.await();//等待偶数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }
    /**
     * 偶数线程打印方式
     */
    public void even(){
        while (i<10){
            lock.lock();
            try{
                if(i%2==0){
                    System.out.println("打印偶数数："+i);
                    i++;
                    condition.signal();//唤醒奇数线程方法打印
                }else{
                    try {
                        condition.await();//等待奇数线程打印完毕
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }

}
