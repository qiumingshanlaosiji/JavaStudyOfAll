package com.study.someMethod;

/**
 * @description jvm相关
 * @date 2019/3/17
 */
public class jvm {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);

    }
}
