package com.budi.thredsafe;

/**
 * @program: javabasic
 * @description:
 * @author:zhaoyongquan
 * @create:2020-08-02-15-43
 **/
public class MainSafeTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //创建一个售票窗口
        Thread thread = new Thread(ticket, "窗口1");
        Thread thread2 = new Thread(ticket, "窗口2");
        Thread thread3 = new Thread(ticket, "窗口3");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
