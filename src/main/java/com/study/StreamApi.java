package com.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @description 流式api
 * @date 2019/2/28
 */
public class StreamApi {

    public static void main(String[] args) {
        test3();
    }

    /*
    过滤
     */
    private void test1() {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        //1.filter
        List<Integer> arrayList1 = arrayList.stream().filter(p -> p > 1).collect(Collectors.toList());

        //2.过滤+去重
        List<Integer> arrayList2 = arrayList.stream().filter(p -> p > 1).distinct().collect(Collectors.toList());

        //3.过滤+去重+limit
        List<Integer> arrayList3 = arrayList.stream().filter(p -> p > 1).distinct().limit(2).collect(Collectors.toList());

        //4.skip   跳过前面n个元素
        List<Integer> arrayList4 = arrayList.stream().filter(p -> p > 1).distinct().limit(2).skip(2).collect(Collectors.toList());

    }


    /*
     映射
     */
    private void test2() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        //1.map
        double[] doubles = arrayList.stream().mapToDouble((a) -> 1).toArray();
        //2.glat mp
        arrayList.stream().map((a) -> 1).collect(Collectors.toList());

        //3.  将a映射到b
        ArrayList<A> arrayList1 = new ArrayList<>();

        List<B> list = arrayList1.stream().map((a) -> new B()).collect(Collectors.toList());

    }

    /*
    终端操作
     */
    private static void test3() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        //1. allMatch 操作  是否存在一个或者多个满足条件
        boolean isC = arrayList.stream().allMatch(a -> a > 0);
        System.out.println(isC);
        //2.noneMatch 都不满足条件
        boolean isC1 = arrayList.stream().noneMatch(a -> a < 0);
        System.out.println(isC1);

        //3.满足条件的第一个值 findFirst
        Integer a1 = arrayList.stream().filter(a -> a > 0).findFirst().get();

        //4.任意一个  findAny
        Integer a12 = arrayList.stream().filter(a -> a > 0).findAny().get();

        //5. 规约

        //收集


    }
}


class A {

}

class B {

}