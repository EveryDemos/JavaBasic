package com.budi.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: javabasic
 * @description: 可重入锁
 * @author:zhaoyongquan
 * @create:2020-08-06-20-47
 **/
public class Reentranlock {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i <10 ; i++) {
            lock.lock();
            System.out.println("枷锁此说"+(i+1));
        }
        for (int i = 0; i <10 ; i++) {
            try {
                System.out.println("解锁次数"+(i+1));
            }finally {
                lock.unlock();
            }
        }
    }
}
