package com.miss27.sync;

/**
 * @author zhao
 * 车票资源类，简单模拟 生产者 生产出一张票，消费者就卖掉
 */
public class Ticket {
    private int number = 0;

    /**
     * 生产票
     *
     * @throws InterruptedException
     */
    public synchronized void incr() throws InterruptedException {
        String currentThread=Thread.currentThread().getName();
        while (number != 0) {//当票的数量不等于0，说明还有票，就不用生产票
            this.wait();
        }
        number++;//如果票==0，则生产一张票
        System.out.println(Thread.currentThread().getName() + "生产了：" + number + "张票");
        this.notifyAll();//唤醒其他线程
    }

    /**
     * 卖票
     *
     * @throws InterruptedException
     */
    public synchronized void decr() throws InterruptedException {
        String currentThread=Thread.currentThread().getName();
        while (number == 0) {//当票数量==0的时候，不能卖票了，进入wait状态
            this.wait();
        }
        number--;//当票数量不等于0，则卖出去一张票
        System.out.println(Thread.currentThread().getName() + "卖出后剩余：" + number + "张票");
        this.notifyAll();//唤醒其他线程
    }
}
