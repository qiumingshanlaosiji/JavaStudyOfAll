package com.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @description 线程池
 * @date 2019/3/16
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        test1();
    }

    /*
    可缓存线程池
     */
    private  static  void  test1(){
        ///可缓存的线程
        //核心线程数  0 最大线程数 无限制  队列是 并发同步阻塞队列
        //每次执行一个线程  执行第二个线程时  第一个线程已经执行完成
        ExecutorService executorService=     Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int temp = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);

                }
            });
        }

    }

    /*
    定长线程池
    LinkedBlockingQueue  使用阻塞无边界队列
     */
    private  static  void  test2(){
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newFixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getId() + ",i:" + temp);
                        Thread.sleep(1000);
                    }
                    catch (Exception e){

                    }

                }
            });
        }

    }

    /*
    定长周期性执行线程池
    核心线程数  自定义   队列为DelayedWorkQueue
  延迟三秒执行
     */
    private  static  void  test3(){

        ScheduledExecutorService newScheduledThreadPool=Executors.newScheduledThreadPool(1);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
                public void run() {
                    try {
                        System.out.println("i:" + temp);
                        Thread.sleep(1000);
                    }
                    catch (Exception e){
                    }

                }
            }, 3, TimeUnit.SECONDS);
        }

    }

    /*
    单线程线程池
     */
    private  static  void  test4(){
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" "+"index:" + index);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            });
        }

    }
}
