package com.study.designPattern;

/**
 * @description 单例模式
 * @date 2018/12/24
 */
public class SingletonPattern {

    public static void main(String[] args) {

    }

}

/*
1  只能用在单线程当中
 */
class Singleton1 {

    private static Singleton1 singleton1 = null;

    private Singleton1() {

    }

    public static Singleton1 getSingleton1() {

        if (singleton1 == null) {

            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

/*
2 饿汉式
 */
class Singleton2 {
    private Singleton2() {

    }

    private static Singleton2 singleton2 = new Singleton2();

    public static Singleton2 getSingleton1() {

        return singleton2;
    }
}

class Singleton3 {
    private Singleton3() {

    }

    private static final Object object = new Object();
    private volatile static Singleton3 singleton3 = null;

    private static Singleton3 getInstance() {
        if (singleton3 == null) {

            synchronized (object) {
                if (singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }

        return singleton3;
    }

}

/*
静态内部类
懒汉模式
 */
class Singleton4 {

    private Singleton4() {

    }

    private static class SingletonHolder {
        private final static Singleton4 SINGLETON_4 = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.SINGLETON_4;

    }

}