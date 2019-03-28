package com.study.arithmetic.sort;

/**
 * @description 插入排序
 * @date 2019/1/23
 */
public class InsertSort {

    public static int[] insertSort(int[] array) {


        for (int i = 0; i < array.length; i++) {

            int m = i - 1;
            int num = array[i];
            while (m >= 0 && array[m] > num) {
                array[m + 1] = array[m];
                m--;
            }
            array[m + 1] = num;
        }


        return array;
    }
}
