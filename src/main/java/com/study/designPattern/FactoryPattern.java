package com.study.designPattern;

/**
 * @description 工厂方法
 * @date 2019/3/1
 */
public class FactoryPattern {
    public static void main(String[] args) {
        Creater creater=new TomatoScrambledEggs1Creater();
        creater.createFactory().print();
    }
}



abstract class Food1 {
    public abstract void print();
}

class TomatoScrambledEggs1 extends Food1 {
    @Override
    public void print() {
        System.out.println("西红柿");
    }
}

class ShreddedPorkWithPotatoes1 extends Food1 {
    @Override
    public void print() {
        System.out.println("土豆肉丝");
    }
}

abstract  class  Creater{
    public  abstract  Food1 createFactory();
}

class  TomatoScrambledEggs1Creater extends  Creater{
    @Override
    public Food1 createFactory() {
        return  new TomatoScrambledEggs1();
    }
}