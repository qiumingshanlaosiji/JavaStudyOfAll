package com.javaStudy.basicPratice.collection.set;

import java.util.HashSet;

/**
 * @description hashset
 * @date 2019/3/31
 */
public class HashSetTest {

    public static void main(String[] args) {
       HashSet<String> hashSet=new HashSet<>(1,2);
    }


    ///hash碰撞性能测试  性能严重下降
    private static   void  test(){
        HashSet<HashSetClass> hashSet = new HashSet<>(3);
        long begin= System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            hashSet.add(new HashSetClass());
        }
        long end= System.currentTimeMillis();
        System.out.println(end-begin);
    }
}


class HashSetClass {
    @Override
    public int hashCode() {
        return 0;
    }
}
