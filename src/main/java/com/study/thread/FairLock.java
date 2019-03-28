package com.study.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description 公平锁和非公平锁
 * @date 2018/12/23
 * 公平锁:如果有另一个线程持有锁或者有其他线程在等待队列中等待这个所，那么新发出的请求的线程将被放入到队列中
 * 非公平锁:只有当锁被某个线程持有时，新发出请求的线程才会被放入队列中
 */
public class FairLock {

    //公平锁
    private ReentrantLock reentrantLock = new ReentrantLock(true);

    //非公平锁
    private ReentrantLock reentrantLock1 = new ReentrantLock(false);


    public void TestFair() {
        try {
            reentrantLock.lock();
            System.out.println("获取锁");

        } finally {
            reentrantLock.unlock();
        }
    }

    public void TestUnFair() {


    }

}

class TestFairLock {

    public void Test() {

        FairLock lock = new FairLock();
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "begin");
            }
        };

        Thread[] threads = new Thread[10];
        for (Thread thread : threads) {
            thread = new Thread(runnable);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }


}
