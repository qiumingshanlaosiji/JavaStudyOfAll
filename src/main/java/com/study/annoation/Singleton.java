package com.study.annoation;

/**
 * @description 单例模式
 * @date 2018/12/6
 * 懒汉式
 * 需要时才进行实例化
 *
 * 懒汉式效率比饿汉式低
 * 饿汉式比懒汉式占资源
 */
public class Singleton {

    public static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (singleton.getClass()) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    public static Singleton getSingleton1() {
        if (singleton == null) {
            synchronized (singleton.getClass()) {
                if (singleton == null) {

                    singleton = new Singleton();
                }
            }

        }
        return  singleton;
    }
}


//饿汉式
class Singleton1 {

    private static Singleton1 singleton1 = new Singleton1();

    public static Singleton1 getSingleton1() {
        return singleton1;
    }

}


