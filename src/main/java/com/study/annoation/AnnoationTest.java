package com.study.annoation;

import javax.print.DocFlavor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @description 注解类
 * @date 2018/12/6
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
public @interface AnnoationTest {
String value() default  "";

int id();

}
