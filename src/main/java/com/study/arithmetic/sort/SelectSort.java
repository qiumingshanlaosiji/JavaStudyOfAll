package com.study.arithmetic.sort;

/**
 * @description 选择排序
 * @date 2019/1/23
 */
public class SelectSort {

    public static int[] selectSort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            int min = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }
}
