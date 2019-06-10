package com.study.thread;

import java.io.PipedReader;
import java.util.concurrent.*;

/**
 * @description 线程池
 * 四种线程池
 * 1.可缓存线程池
 * 2.创建固定长度线程池
 * 3.创建定长线程池,支持定时以及周期性任务执行
 * @date 2018/12/22
 */
public class ThreadPool {

    /*
    四种创建线程池方式
     */
    private static void test1() {

        ExecutorService executorService=Executors.newFixedThreadPool(1);
        //定长线程池
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.execute(() -> {
            try {

                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1234);


            } catch (Exception e) {

            }

        });
        executorService1.execute(() -> {
            try {
                System.out.println(Thread.currentThread().getName());

                Thread.sleep(1234);

            } catch (Exception e) {

            }

        });
    }

    public static void main(String[] args) {
        test1();
    }

    //可缓存线程池
    public void Test() throws Exception {
        //无限制大小
        ExecutorService executorService = Executors.newCachedThreadPool();
        //固定大小的线程数
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);
                }
            });
        }
        Thread.sleep(1000);

    }
}

class DefinedThreadPool {

    public void test() {

        //核心线程数 1  (实际执行线程)  一直会存活  即时没有线程执行
        // 当线程数小于核心线程数时，即使有线程空闲，线程池也会优先创建新线程处理

        //最大创建线程数 2  当线程数>=corePoolSize，且任务队列已满时。线程池会创建新线程来处理任务
        // 当线程数=maxPoolSize，且任务队列已满时，线程池会拒绝处理任务而抛出异常

        //队列  当核心线程数达到最大时，新任务会放在队列中排队等待执行

        //keepAliveTime：线程空闲时间
        //当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
        //如果allowCoreThreadTimeout=true，则会直到线程数量=0
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 10, 0L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2));
        //创建线程  现在执行
        threadPoolExecutor.execute(new TaskThread("task1"));
        //放在队列缓存
        threadPoolExecutor.execute(new TaskThread("task2"));
        //放在队列缓存
        threadPoolExecutor.execute(new TaskThread("task3"));
        //放在队列缓存
        threadPoolExecutor.execute(new TaskThread("task4"));
        //创建线程
        threadPoolExecutor.execute(new TaskThread("task5"));
        // error 队列已满
        threadPoolExecutor.execute(new TaskThread("task6"));


    }

    class TaskThread implements Runnable {

        private String threadName;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " " + threadName);
        }

        public TaskThread(String threadName) {
            this.threadName = threadName;
        }

    }

    public static void main(String[] args) throws Exception {
        new ThreadPool().Test();
    }

}
