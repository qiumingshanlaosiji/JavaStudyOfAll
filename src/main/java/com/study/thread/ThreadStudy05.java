package com.study.thread;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description 多线程之间的通信
 * @date 2018/12/5
 */
public class ThreadStudy05 {

    /*
    先进先出
     */
    public void Test() {
        //非阻塞队列    性能比阻塞队列好
        ConcurrentLinkedDeque q = new ConcurrentLinkedDeque();
        q.offer("");
        q.poll();
        q.size();
    }
}

/*
阻塞队列
生产者
 */
class ProductBlockQuene extends Thread {
    private BlockingQueue<String> blockingQueue;

    private AtomicInteger count = new AtomicInteger();

    private volatile boolean flag = true;

    public ProductBlockQuene(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "生产者开始启动");
        while (flag) {
            String data = count.incrementAndGet() + "";
            try {
                boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + "生产队列" + data + "成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "生产队列" + data + "失败");


                }
                Thread.sleep(1000);
            } catch (Exception e) {


            }

        }
        super.run();
    }

    public void Stop() {

        this.flag = false;
    }
}

class CousumerBlockQuene extends Thread {

    private BlockingQueue<String> blockingQueue;


    private volatile boolean flag = true;

    public CousumerBlockQuene(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "消费者开始启动");
        while (flag) {
            try {
                String data = blockingQueue.poll(2, TimeUnit.SECONDS);
                if (data == null || data == "") {
                    flag = false;
                    System.out.println("Time out");
                    return;
                }
                System.out.println("消费者拿到数据:" + data);
            } catch (Exception e) {

            }

        }

    }
}

class BlockQueneTest {

    public void test() {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue(3);
        ProductBlockQuene productBlockQuene = new ProductBlockQuene(blockingQueue);
        CousumerBlockQuene cousumerBlockQuene = new CousumerBlockQuene(blockingQueue);
        Thread t1=new Thread(productBlockQuene);
        Thread t2=new Thread(cousumerBlockQuene);
        t1.start();
        t2.start();
        try {
            Thread.sleep(10000);
            productBlockQuene.Stop();
        }
        catch (Exception e){


        }

    }
}
