package com.study.collection;

import javax.naming.LinkLoopException;
import java.util.*;

/**
 * @description 手写集合
 * @date 2018/12/28
 * //基于Object[] elementData实现
 */
public class ExtArraylist {

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private int size;

    private Object[] elementData;

    //若没有指定初始容量  那么指定十个初始容量
    public ExtArraylist() throws Exception {
        this(0);
    }

    //指定初始容量
    public ExtArraylist(int initialCapacity) throws Exception {

        size = initialCapacity;
        if (initialCapacity < 0) {
            throw new IllegalAccessException("初始容量不能小于0");
        }
        elementData = new Object[initialCapacity];
    }

    //增加元素后  判断长度大小  进行扩容处理  每次扩容原来数组的一倍
    private void grow(int minCapacity) {

        int oldCapacity = elementData.length;
        //>>右移运算符    若要增加   增加新的容量的大小
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }

        //如果超过最大数组上限长度
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }

        //将数组扩容  产生新的数组
        elementData = Arrays.copyOf(elementData, newCapacity);

    }

    public boolean add(Object object) {
        //1.先去扩容
        //当前容量+1
        ensureExplicitCapacity(size + 1);
        elementData[size++] = object;
        return true;
    }

    public boolean remove(int index) {
        Object object=get(index);
        int numMoved=elementData.length-index-1;
        if(numMoved>0){
            //将数组从index+1开始的位置  拷贝numMoved位 到index开始的位置上
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size]=null;

        return  true;
    }

    private  Object get(int index){

        rangeCheck(index);

        return  elementData[index];
    }
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("越界");
    }
    private void ensureExplicitCapacity(int minCapacity) {
        //如果存入的数字  超过了默认数组初始容量  就开始扩容
        if (size == elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
}
