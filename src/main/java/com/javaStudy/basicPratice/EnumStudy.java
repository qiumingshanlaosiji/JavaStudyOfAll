package com.javaStudy.basicPratice;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * @description 枚举学习
 * @date 2019/3/29
 */
public class EnumStudy {
    public static void main(String[] args) {
        //根据名称获取枚举
        a a1 = Enum.valueOf(a.class, "a1");

        System.out.println(b.MALE.getName());



    }
}


enum a {
    a1, a2, a3
}

enum b {
    MALE("男"), FEMALE("女");

    private final String name;

    private b(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

//实现接口
enum  c implements i
{

MAIL{
    @Override
    public void getName() {

    }
}

}
interface  i{
    void  getName();
}