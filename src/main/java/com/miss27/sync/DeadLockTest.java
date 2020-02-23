package com.miss27.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhao 死锁
 */
public class DeadLockTest {
    private static Object objectA = new Object();
    private static Object objectB = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (objectA) {
                System.out.println("获取了A资源");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("正在等待获取B资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (objectB) {
                    System.out.println("获取了B资源");
                }
            }

        }).start();

        new Thread(() -> {
            synchronized (objectB) {
                System.out.println("获取了B资源");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("正在等待获取A资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (objectA) {
                    System.out.println("获取了A资源");
                }
            }
        }).start();
    }
}
