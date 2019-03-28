package com.study.queue;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @description 非阻塞队列
 * @date 2019/3/16
 */
public class UnBlockQueueTest {

    public static void main(String[] args) {

    }


    /*
    非阻塞队列的使用
    双向链表
    现了Deque接口，表示一个双端队列，在两端都可以入队和出队，内部是一个双向链表
     */
    private  static  void  test1(){

        ConcurrentLinkedDeque q = new ConcurrentLinkedDeque();
        q.offer("余胜军");
        q.offer("码云");
        q.offer("蚂蚁课堂");
        q.offer("张杰");
        q.offer("艾姐");
        //从头获取元素,删除该元素
        System.out.println(q.poll());
        //从头获取元素,不刪除该元素
        System.out.println(q.peek());
        //获取总长度
        System.out.println(q.size());
    }

    /*
    无界队列  内部是一个数组  内部是单向链表
    实现了Queue接口，表示一个先进先出的队列，从尾部入队，从头部出队，内部是一个单向链表
     */
    private  static  void  test2(){
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.offer("余胜军");
        concurrentLinkedQueue.offer("码云");
        concurrentLinkedQueue.offer("蚂蚁课堂");
        concurrentLinkedQueue.offer("张杰");
        concurrentLinkedQueue.offer("艾姐");
        //从头获取元素,删除该元素
        System.out.println(concurrentLinkedQueue.poll());
        //从头获取元素,不刪除该元素
        System.out.println(concurrentLinkedQueue.peek());
        //获取总长度
        System.out.println(concurrentLinkedQueue.size());
    }
}
