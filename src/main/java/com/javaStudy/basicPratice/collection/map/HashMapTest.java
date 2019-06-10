package com.javaStudy.basicPratice.collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * @description
 * @date 2019/3/31
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap=new HashMap<>(15);
       for (int i=0;i<15;i++){
           hashMap.put(i,i);
       }
        hashMap.put(16,3);
    }
}
