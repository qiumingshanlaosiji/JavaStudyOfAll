package com.study.thread;

/**
 * @description threadlocal
 * @date 2018/12/22
 */
public class ThreadLocalStudy extends Thread {

    private Res res = new Res();

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + res.getNum());
        }
    }

}

class Res {

    public static Integer count = 0;

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal() {
        protected Integer initialValue() {

            return 0;

        }
    };

    public Integer getNum() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;

    }
}