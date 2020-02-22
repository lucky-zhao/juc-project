package com.miss27.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author zhao
 * 同一个对象调用个一个非静态的同步方法和一个非静态非同步方法
 */
public class SyncTest02 {

    public static void main(String[] args) throws InterruptedException {
        Print2 print = new Print2();
        new Thread(() -> {
            try {
                print.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {
            try {
                print.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();



    }
}

class Print2 {
    public synchronized void printA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("A");
    }

    public void printB() throws InterruptedException {
        System.out.println("B");
    }
}
