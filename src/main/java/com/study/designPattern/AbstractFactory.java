package com.study.designPattern;

/**
 * @description 抽象工厂
 * @date 2019/3/1
 */
class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new NanChangFactor();
        Yabo yabo = abstractFactory.createYaBo();
        yabo.print();
    }
}


public abstract class AbstractFactory {
    abstract Yabo createYaBo();

    abstract YaJia createYaJia();


}

class NanChangFactor extends AbstractFactory {
    @Override
    Yabo createYaBo() {
        return new NanChangYabo();
    }

    @Override
    YaJia createYaJia() {
        return null;
    }
}


abstract class Yabo {
    abstract void print();
}

abstract class YaJia {
    abstract void print();
}

class NanChangYabo extends Yabo {
    @Override
    void print() {

    }
}

class ShangHaiYaBo extends Yabo {
    @Override
    void print() {

    }
}

class ShangHaiYaJia extends YaJia {
    @Override
    void print() {

    }
}