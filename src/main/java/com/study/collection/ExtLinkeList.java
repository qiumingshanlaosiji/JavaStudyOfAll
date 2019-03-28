package com.study.collection;


/**
 * @description LinkeList
 * @date 2018/12/28
 */
public class ExtLinkeList<T> {

    private Node first;

    private Node last;

    private int size;


    private class Node {

        Node prev;

        Object object;

        Node next;
    }

    public void add(T t) {
        Node node = new Node();
        node.object = t;

        if (first != null) {
            first = node;
        } else {

            //存放上一个节点的内容
            node.prev = last;
            //下一个节点的内容
            last.next = node;
        }

        last = node;

        size++;
    }

    public void removeNode(int index) {
        checkElementIndex(index);

        Node node = getNode(index);
        if (node != null) {

            Node prev = node.prev;

            Node next = node.next;

            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.prev=prev;
            }
        }
        size--;
    }


    public void checkElementIndex(int index) {

        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("越界拉");
        }


    }

    public boolean isElementIndex(int index) {
        return size > index && index >= 0;
    }

    //指定位置存放
    public void add(int index, T t) {
        Node newNode = new Node();
        newNode.object = t;
        //获取原来节点上的node
        ExtLinkeList<T>.Node oldNode = getNode(index);

        //获取上一个节点
        ExtLinkeList<T>.Node oldNodePrev = oldNode.prev;

        //新增节点的上一个还是当前node节点
        //原来的上一个节点变为当前节点
        oldNode.prev = newNode;

        if (oldNodePrev == null) {
            first = newNode;
        } else {
            oldNodePrev.next = newNode;
        }
        newNode.next = oldNode;

        size++;
    }

    private ExtLinkeList<T>.Node getNode(Integer index) {
        Node node = null;
        if (first != null) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }
}
