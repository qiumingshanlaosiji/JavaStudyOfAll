package com.javaStudy.basicPratice.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * @description 集合相关的一些操作
 * @date 2019/3/31
 */
public class CollectionMethod {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        //1.
        arrayList.forEach(p-> System.out.println(p));

        //2.
        for (Integer integer:arrayList){
            System.out.println(integer);
        }

        //3.predicate相关操作
        arrayList.removeIf(p->p>0);

        //4.流操作
        arrayList.stream().filter(p->p>0);


    }
}
