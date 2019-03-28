package com.study.thread;

import java.time.LocalDate;

/**
 * @description 线程之前的通信
 * @date 2019/3/16
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        Person res = new Person();
        IntThrad intThrad = new IntThrad(res);
        OutThread outThread = new OutThread(res);
        intThrad.start();
        outThread.start();

    }
}


class OutThread extends Thread {
    private Person res;

    public OutThread(Person res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                if (!res.flag) {
                    try {
                        res.wait();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
                System.out.println(res.userName + "--" + res.userSex);
                res.flag = false;
                res.notify();
            }
        }
    }
}
class IntThrad extends Thread {
    private Person res;

    public IntThrad(Person res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {
                if (res.flag) {
                    try {
                        // 当前线程变为等待，但是可以释放锁
                        res.wait();
                    } catch (Exception e) {

                    }
                }
                if (count == 0) {
                    res.userName = "小军"+ LocalDate.now();
                    res.userSex = "男";
                } else {
                    res.userName = "小紅"+ LocalDate.now();
                    res.userSex = "女";
                }
                count = (count + 1) % 2;
                res.flag = true;
                // 唤醒当前线程
                res.notify();
            }

        }
    }
}
class Person {
    public String userSex;
    public String userName;
    //线程通讯标识
    public boolean flag = false;
}
