package com.study.collection;

import java.util.Arrays;
import java.util.List;

/**
 * @description test
 * @date 2018/12/28
 */
public class CollectionTest {

    public void test() {


        //1.数组复制
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        int[] newArray = Arrays.copyOf(array, 20);
        //分析   将array从0开始的位置开始截图   复制四个  到 从newArray位置3开始
        System.arraycopy(array,0,newArray,3,4);

    }
}
