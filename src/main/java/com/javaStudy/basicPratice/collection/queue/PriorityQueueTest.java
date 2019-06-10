package com.javaStudy.basicPratice.collection.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * @description
 * @date 2019/3/31
 */
public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.offer(1);
        System.out.println( priorityQueue.poll());
        System.out.println( priorityQueue.poll());

    }
}
