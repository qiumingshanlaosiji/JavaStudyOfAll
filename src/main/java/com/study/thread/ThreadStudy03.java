package com.study.thread;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @description 多线程同步
 * @date 2018/12/5
 * 线程安全
 * 当多个线程同时共享同一个全局变量或者静态变量,在写操作时,可能会发生数据冲突
 */
public class ThreadStudy03 implements Runnable {

    private Object obj = new Object();
    private int count = 10;


    @Override
    public void run() {
        //同步快
        synchronized (obj) {
            while (count > 0) {
                System.out.printf("" + count);
                count--;
            }
        }
    }

    //同步函数使用this锁
    private  synchronized  void show(){

    }

    //静态同步代码块
    private  static  synchronized  void  show1(){


    }


}
