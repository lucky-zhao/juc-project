package com.miss27.sync;

/**
 * @author zhao 线程虚假唤醒
 */
public class TestTicket {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        //A线程生产票
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    ticket.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        //B线程生产票
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    ticket.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        //C线程卖票
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    ticket.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        //D线程卖票
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    ticket.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }
}
