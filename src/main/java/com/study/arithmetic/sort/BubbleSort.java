package com.study.arithmetic.sort;

/**
 * @description 冒泡排序
 * @date 2019/1/23
 */
public class BubbleSort {


    public  static  int[] bubbleSort(int[] array){

        for (int i=0;i<array.length;i++){

            for (int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
        return  array;
    }





}
