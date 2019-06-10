package com.javaStudy.basicPratice;

/**
 * @description string的相关方法
 * @date 2019/3/30
 */
public class StringMethod {

    public static void main(String[] args) {
        String a="asdasd我们";
        System.out.println(a.length());//获取长度
        System.out.println(a.charAt(1));//获取指定index上的字符
         char[] chars=a.toCharArray();//转为char数组
        System.out.println(a.equalsIgnoreCase("Asdasd我们")); //忽略大小写比较s
        System.out.println(a.compareTo("a1"));//比较
        System.out.println(a.regionMatches(0,"sd",3,2));//比较区域长度
        System.out.println(a.indexOf('a')); //获取字符的下标


    }
}
