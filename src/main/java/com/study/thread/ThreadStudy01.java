package com.study.thread;

import com.sun.xml.internal.ws.handler.HandlerException;

/**
 * @description 多线程
 * @date 2018/12/5
 *thread和Runnable对比   Runnable更好
 * 实现Runnable接口比继承Thread类所具有的优势：
 *
 * 1）：适合多个相同的程序代码的线程去处理同一个资源
 *
 * 2）：可以避免java中的单继承的限制
 *
 * 3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
 */
public class ThreadStudy01  implements  Runnable{

    ///HandlerException
    @Override
    public  void  run()     {

        try {
            Thread.sleep(1000);
            System.out.printf("1213123");

        }
        catch (Exception e)
        {

        }



    }

}

class ThreadStudy01Test{
    public static void main(String[] args) {
        ThreadStudy01 threadStudy01=new ThreadStudy01();
        Thread thread=new Thread(threadStudy01);
        thread.start();
    }
}