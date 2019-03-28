package com.study.annoation;

import java.lang.reflect.Field;

/**
 * @description 注解学习
 * @date 2018/12/6
 */
@AnnoationTest(value = "asd", id = 2)
public class Study {

    @AnnoationTest(value = "asd", id = 2)
    int name;

    public void getAnno() throws Exception {
        Class<?> forName = Class.forName("com.study.annoation.Study");
        AnnoationTest test = forName.getAnnotation(AnnoationTest.class);

        Field[] decla = forName.getDeclaredFields();

        for (Field field : decla) {

            AnnoationTest tesxt = field.getAnnotation(AnnoationTest.class);

        }

    }
}
