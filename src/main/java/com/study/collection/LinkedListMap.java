package com.study.collection;

import java.util.LinkedList;
import java.util.Map;

/**
 * @description LinkedListMap
 * @date 2018/12/28
 */
public class LinkedListMap {

    LinkedList<Entry>[] tables = new LinkedList[998];

    private int size;

    public void put(Object key, Object value) {
        Entry newEntry = new Entry(key, value);
        int hash = getHash(key);

        //判断是否已经在数中
        LinkedList<Entry> entryLinkedList = tables[hash];
        if (entryLinkedList == null) {
            LinkedList<Entry> linkedList = new LinkedList<>();
            linkedList.add(newEntry);

        } else {
            for (Entry entry : entryLinkedList) {
                if (entry.key.equals(key)) {
                    entry.value = value;

                } else {
                    entryLinkedList.add(newEntry);
                }
            }

        }

    }

    private int getHash(Object key) {
        int hashCode = key.hashCode();
        int hash = hashCode % tables.length;
        return hash;
    }
}

class Entry {

    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    Object key;
    Object value;

}
