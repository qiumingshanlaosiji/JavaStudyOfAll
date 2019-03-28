package com.study.queue;


import java.util.concurrent.*;

/**
 * @description 阻塞队列
 * @date 2019/3/16
 */
public class BlockQueueTest {

    public static void main(String[] args) throws  Exception {

        test1();

    }

    /*
ArrayBlockingQueue
是一个有边界的阻塞队列，它的内部实现是一个数组。
有边界的意思是它的容量是有限的，我们必须在其初始化的时候指定它的容量大小，
容量大小一旦指定就不可改变。
ArrayBlockingQueue是以先进先出的方式存储数据，最新插入的对象是尾部，最新移出的对象是头部
     */
    private  static  void  test1() throws InterruptedException{
        ArrayBlockingQueue<Integer> arrayBlockingQueue=new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer(1);
        arrayBlockingQueue.offer(2);
        arrayBlockingQueue.offer(2);

        //满了就会等待
        arrayBlockingQueue.offer(5, 5, TimeUnit.SECONDS);
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
       System.out.println(arrayBlockingQueue.poll());
       //队列没有值  就会等待
        System.out.println(arrayBlockingQueue.poll(3,TimeUnit.SECONDS));

    }

    /*
    LinkedBlockingQueue
    LinkedBlockingQueue阻塞队列大小的配置是可选的，
    如果我们初始化时指定一个大小，它就是有边界的，如果不指定，它就是无边界的。说是无边界，
    其实是采用了默认大小为Integer.MAX_VALUE的容量 。它的内部实现是一个链表。
     */
    private  static  void  test2() throws Exception{
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(3);
        linkedBlockingQueue.offer("张三");
        linkedBlockingQueue.offer("李四");
        linkedBlockingQueue.offer("李四",1,TimeUnit.SECONDS);
        System.out.println(linkedBlockingQueue.size());

    }
}
