package com.studyForRule.normalStudy.normal;

/**
 * 初始化学习
 */
public class InitStudy {


    public static void main(String[] args) {
        Cat cat = new Cat();
    }


}


  class Animal {



    private static String a = "静态animall";

    static {
        System.out.println(a);
    }

    private String b = "非静态animal";

    {

        System.out.println(b);

    }

    Animal() {

        System.out.println("animal构造函数");
    }


}

class Cat extends Animal {

    private static String a = "静态Cat";

    static {
        System.out.println(a);
    }

    private String b = "非静态Cat";

    {
        System.out.println(b);
    }

    Cat() {

        System.out.println("Cat构造函数");
    }


}