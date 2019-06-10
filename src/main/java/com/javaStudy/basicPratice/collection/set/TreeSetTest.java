package com.javaStudy.basicPratice.collection.set;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @description treeset
 * @date 2019/3/31
 */
public class TreeSetTest {

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        //定制排序  降序
        TreeSet<Integer> hashSet = new TreeSet<Integer>((o1, o2) -> {
            return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);

        });
        hashSet.add(2);
        hashSet.add(1);
        hashSet.forEach(p -> System.out.println(p));

    }
}


