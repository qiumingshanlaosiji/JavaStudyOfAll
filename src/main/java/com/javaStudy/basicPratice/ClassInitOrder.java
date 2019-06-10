package com.javaStudy.basicPratice;

import javax.sound.midi.Soundbank;

/**
 * @description 类初始化顺序
 * @date 2019/3/29
 */
public class ClassInitOrder {


    public static void main(String[] args) {
        B b=new B();
        System.out.println("11111111111111111111111111111111111");
        B b1=new B();
    }
}


class  A{

    static  int a=1;

    static {
        System.out.println("A的静态a值"+a);
        System.out.println("A的静态代码块");
    }
    private int b=2;
    {
        System.out.println("A的b值"+b);
        System.out.println("A的普通代码块");
    }
    public  A(){
        System.out.println("A的构造函数");
    }

}

class  B extends A{

    static  int a=1;

    static {
        System.out.println("B的静态a值"+a);
        System.out.println("B的静态代码块");
    }
    private int b=2;
    {
        System.out.println("B的b值"+b);
        System.out.println("B的普通代码块");
    }
    public  B(){
        System.out.println("B的构造函数");
    }



}