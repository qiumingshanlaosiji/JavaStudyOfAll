package com.study.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description ExtArrayListMap
 * @date 2018/12/28
 */
public class ExtArrayListMap<K, V> {
    List<Map.Entry<K, V>> tables = new ArrayList<>();

    public void put(K key, V value) {
        Map.Entry existEntry = getEntry(key);
        if(existEntry!=null){
            existEntry.setValue(value);
            return;
        }
       // Map.Entry entry = new Map.Entry<K, V>(key, value);
    }


    private Map.Entry getEntry(K key) {
        for (Map.Entry<K, V> entry : tables) {

            if (entry.getKey().equals(key)) {
                return entry;
            }
        }
        return null;
    }
}
