package com.study.designPattern;

/**
 * @description 简单工厂
 * @date 2019/3/1
 */
public class SimpleFactory {

    private static Food cook(String type) {

        switch (type) {
            case "西红柿":
                return new TomatoScrambledEggs();
            case "土豆":
                return new ShreddedPorkWithPotatoes();
            default:
                return new TomatoScrambledEggs();
        }
    }

    public static void main(String[] args) {
        cook("西红柿");
    }
}



abstract class Food {
    public abstract void print();
}

class TomatoScrambledEggs extends Food {
    @Override
    public void print() {
        System.out.println("西红柿");
    }
}

class ShreddedPorkWithPotatoes extends Food {
    @Override
    public void print() {
        System.out.println("土豆肉丝");
    }
}