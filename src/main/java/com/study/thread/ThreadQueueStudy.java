package com.study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description 并发队列
 * @date 2019/2/17
 */
public class ThreadQueueStudy {

    private  void  test(){
        //阻塞队列
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<Integer>(2) ;
        //非阻塞 单项链表
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue=new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.offer(1);
        //非阻塞  双向
        ConcurrentLinkedDeque<String> concurrentLinkedDeque=new ConcurrentLinkedDeque<String>();

    }

}
