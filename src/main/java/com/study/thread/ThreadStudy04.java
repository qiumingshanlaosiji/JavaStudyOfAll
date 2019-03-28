package com.study.thread;

/**
 * @description 死锁
 * @date 2018/12/5
 * 同步中嵌套同步  导致无法释放锁
 */
public class ThreadStudy04 implements Runnable {

    public static void main(String[] args) throws  Exception {
        ThreadStudy04 threadStudy04=new ThreadStudy04();
        Thread thread=new Thread(threadStudy04,"窗口1");
        Thread thread1=new Thread(threadStudy04,"窗口2");

        thread.start();

        Thread.sleep(100);
        threadStudy04.flag=false;
        thread1.start();
    }

    private int count = 100;

    private Object object = new Object();
    public  boolean flag=true;

    //分析
    //锁在代码执行完毕后 锁自动被释放掉
    //如果为true 先拿到object锁  再去拿this锁
    //为fale 先拿this锁  再拿object锁
    //在某一时间  两个锁同时没有被释放掉
    //同一个线程  锁是可以传递的

    @Override
    public void run() {
        if(flag){
            while (count > 0) {
                synchronized (object) {
                    show();
                }

            }
        }
        else {
while (count>0){
    show();
}

        }


    }

    private synchronized void show() {

        synchronized (object) {

            if (count > 0) {
                try {
                    Thread.sleep(120);
                }
                catch (Exception e){


                }
                System.out.printf("" + count);

                count--;
            }
        }
    }
}
