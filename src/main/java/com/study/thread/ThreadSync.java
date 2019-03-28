package com.study.thread;

import java.util.concurrent.*;

/**
 * @description 返回结果
 * @date 2018/12/22
 */
public class ThreadSync implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("executing! ");
        return "嘿嘿嘿";
    }
}

class ThreadSyncTest {

    public void Test() {
        try {
            ExecutorService executorService= Executors.newCachedThreadPool();
            Future<String> sumbit=executorService.submit(new ThreadSync());
            FutureTask<String> futureTask=new FutureTask(new ThreadSync());
            executorService.execute(futureTask);
            if(futureTask.isDone()){



            }

            System.out.println("主线程正在运行");
            //获取结果时  整个程序处于阻塞状态
            String result=sumbit.get();
            System.out.println(result);

        } catch (Exception e) {


        }


    }

}
