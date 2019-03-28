package com.study.thread;


public class ThreadStudy extends Thread {

    ///方式1  重写run 使用start运行
    //上下文切换
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            System.out.printf("121123");
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws  Exception {
        Thread thread=new Thread(()->{
            System.out.println(1);
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
    }
}
