package com.miss27.sync;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author zhao
 * 同一个对象调用两个普通的同步方法
 */
public class SyncTest01 {

    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
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

class Print {
    public synchronized void printA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("A");
    }

    public synchronized void printB() throws InterruptedException {
        System.out.println("B");
    }

}
