package com.study.thread;

/**
 * @description 匿名内部内创建
 * @date 2018/12/5
 *
 * 多线程运行状态  新建状态  就绪状态  阻塞状态  运行状态  死亡状态
 * 开线程浪费cpu资源
 */
public class ThreadStudy02 {

   public  void  threadTest(){
      new Thread(new Runnable() {
           @Override
           public void run() {

           }
       }).start();
   }

   public  void  threadMethod(){
       try {

           Thread.sleep(1000);
       Thread currentThread=    Thread.currentThread();
           Thread thread=new Thread();
           thread.getId();
           thread.getName();
           thread.stop();

       }catch (Exception e){


       }

   }
}
