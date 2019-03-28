package com.study.arithmetic.sort;

/**
 * @description 快排
 * @date 2019/1/23
 */
public class QuickSort {

    public static int[] quickSort(int[] array, int l, int r) {

        if (l < r) {
            int i = l;
            int j = r;
            int num = array[l];
            while (i < j) {

                while (i < j && array[j] > num) {
                    j--;
                }
                if (i < j) {
                    array[i++] = array[j];
                }
                while (i < j && array[i] < num) {
                    i++;

                }
                if (i < j) {
                    array[j--] = array[i];
                }


            }
            array[i] = num;
            quickSort(array, l, i - 1);
            quickSort(array, i + 1, r);

        }
        return array;
    }
}
