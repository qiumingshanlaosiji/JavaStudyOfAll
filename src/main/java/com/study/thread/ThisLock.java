package com.study.thread;

/**
 * @description 证明同步代码块就是this锁
 * @date 2019/3/16
 */
public class ThisLock {

    public static void main(String[] args)  throws Exception{
        Thread009 threadTrain = new Thread009();
        Thread t1 = new Thread(threadTrain, "窗口1");
        Thread t2 = new Thread(threadTrain, "窗口2");
        t1.start();
        Thread.sleep(40);
        threadTrain.flag = false;  //改变的瞬间会导致竞争
        t2.start();
        threadTrain.flag = true;
        Thread.sleep(40);

    }
}
class Thread009 implements Runnable {
    private int trainCount = 100;
    private Object oj = new Object();
    public boolean flag = true;

    public void run() {

        if (flag) {
            while (trainCount > 0) {
                synchronized (this) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    if (trainCount > 0) {
                        System.out
                                .println(Thread.currentThread().getName() + "," + "出售第" + (100 - trainCount + 1) + "票");
                        trainCount--;
                    }
                }

            }
        } else {
            while (trainCount > 0) {
                sale();
            }

        }

    }

    public synchronized void sale() {

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (trainCount > 0) {
            System.out.println(Thread.currentThread().getName() + "," + "出售第" + (100 - trainCount + 1) + "票");
            trainCount--;
        }

    }
}
