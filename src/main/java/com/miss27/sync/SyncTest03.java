package com.miss27.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author zhao
 * 两个对象调用两个同步方法
 */
public class SyncTest03 {

    public static void main(String[] args) throws InterruptedException {
        //创建两个对象实例
        Print3 print = new Print3();
        Print3 pt = new Print3();
        new Thread(() -> {
            try {
                print.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();


        new Thread(() -> {
            try {
                pt.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}

class Print3 {
    public synchronized void printA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);//模拟业务代码，假设业务需要执行3秒
        System.out.println("A");
    }

    public synchronized void printB() throws InterruptedException {
        System.out.println("B");
    }
}
