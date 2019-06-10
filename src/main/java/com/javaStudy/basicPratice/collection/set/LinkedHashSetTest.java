package com.javaStudy.basicPratice.collection.set;

import javassist.bytecode.Descriptor;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @description aa
 * @date 2019/3/31
 */
public class LinkedHashSetTest {

    public static void main(String[] args) {

        test1();
    }

    private  static  void  test1(){
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet();
        linkedHashSet.add(2);
        linkedHashSet.add(null);

        Iterator iterator=linkedHashSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
