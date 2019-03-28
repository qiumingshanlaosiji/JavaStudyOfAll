package com.study.designPattern;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.PublicKey;

/**
 * @description 反射
 * @date 2018/12/23
 */

public class Refelection {
    public Refelection(String name) {

    }

    public String test() {
        return "";
    }

    public String test(String name) {
        return "";

    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String[] strArray;

    public String[] getStrArray() {
        return strArray;
    }

    public void setStrArray(String[] strArray) {
        this.strArray = strArray;
    }
}

class RefelectionTest {

    public void Test() throws Exception {
        //获取class对象的三种方式
        //1. 使用forName
        Class<?> forname = Class.forName("com.study.designPattern.Refelection");
        Refelection refelection = (Refelection) forname.newInstance();
        //2.调用对象的class  代码更加安全1  程序性能更好
        Class<?> testClass = Refelection.class;
        //3.调用对象的getclass
        Refelection refelection1 = new Refelection("");
        Class<?> testclass1 = refelection1.getClass();


        //使用反射生成  操作对象
        //1.生成对象
        Refelection refelection2 = (Refelection) forname.getConstructor().newInstance();

        //2.使用指定构造器创建java对象
        Constructor constructor = forname.getConstructor(String.class);
        Refelection refelection3 = (Refelection) constructor.newInstance("test");

        //3.调用方法
        //(1)无参
        Method method = forname.getMethod("test");
        Object obj = method.invoke(refelection3);

        //(2)有参
        Method method1 = forname.getMethod("test", String.class);
        Object obj1 = method1.invoke(refelection3, "");

        //4.获取字段
        //获取所有类型
        Field field = forname.getDeclaredField("name");
        String nameValue = (String) field.get(refelection3);
        field.setAccessible(true);
        field.set(refelection3, "asdad");

        //获取公共的
        Field field1 = forname.getField("name");

        //5.操作数组
        //创建为10个长度的字符串数组

        Object obj2 = Array.newInstance(String.class, 10);
        //将index为0赋值
        Array.set(obj2, 0, "0");
        String result = (String) Array.get(obj2, 0);
    }


}

