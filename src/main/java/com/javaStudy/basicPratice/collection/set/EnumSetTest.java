package com.javaStudy.basicPratice.collection.set;

import java.util.EnumSet;

/**
 * @description
 * @date 2019/3/31
 */
public class EnumSetTest {

    public static void main(String[] args) {
        EnumSet<EnumSetEnum> enumSetEnums=EnumSet.of(EnumSetEnum.a);


    }
}

enum  EnumSetEnum{
    a,b,c
}
