package com.javaStudy.basicPratice.collection.list;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description arraylist
 * @date 2019/3/31
 */
public class ArraylistTest {

    public static void main(String[] args) {
        test1();
    }
    private static void test1(){

        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1,2);
    }

    private static void test() {
        //Iterator测试
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        //获取Iterator
        Iterator iterator = arrayList.iterator();
        //使用lambda表达式操作
        iterator.forEachRemaining(p-> System.out.println(p));

        //判断是否还有下个节点
        while (iterator.hasNext()) {
            //获取下个节点
            Integer integer = (Integer) iterator.next();
            System.out.println(integer);

            //删除当前元素
            iterator.remove();
        }
        Iterator iterator1 = iterator;
    }
}
