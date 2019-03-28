package com.study.thread;

import java.util.concurrent.*;

/**
 * @description 异步线程
 * @date 2019/3/16
 */
public class AsyncThreadTest {
    public static void main(String[] args)  throws Exception{
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new AddNumberTask());
        System.out.println(Thread.currentThread().getName() + "线程执行其他任务");
        Integer integer = future.get(1, TimeUnit.SECONDS);
        System.out.println(integer);
        // 关闭线程池
        if (executor != null)
            executor.shutdown();
    }

}

class AddNumberTask implements Callable<Integer> {

    public AddNumberTask() {

    }

    @Override
    public Integer call() throws Exception {
        System.out.println("####AddNumberTask###call()");
        Thread.sleep(5000);
        return 5000;
    }

}



