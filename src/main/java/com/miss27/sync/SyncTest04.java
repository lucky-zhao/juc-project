package com.miss27.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author zhao
 * 一个对象调用两个静态同步方法
 */
public class SyncTest04 {

    public static void main(String[] args) throws InterruptedException {
        Print4 print = new Print4();
        new Thread(() -> {
            print.printA();
        }, "A").start();

        TimeUnit.SECONDS.sleep(2);//休眠main线程，让A线程先获取锁
        new Thread(() -> {
            print.printB();
        }, "B").start();
    }
}

class Print4 {
    public static synchronized void printA() {
        System.out.println("A");
    }

    public static synchronized void printB() {
        System.out.println("B");
    }
}
