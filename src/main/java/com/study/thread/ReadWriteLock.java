package com.study.thread;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description 读写锁
 * @date 2018/12/23
 */
public class ReadWriteLock {
    public static void main(String[] args) {

    }
    //读写锁
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //写入锁
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private Map<Object, Object> caChe = new HashMap();

    public void put(String key, String value) {
        try {
            writeLock.lock();
            System.out.println("写入数据");
            caChe.put(key, value);

        } catch (Exception e) {

        } finally {
            writeLock.unlock();
        }

    }

    public String get(String key) {
        try {
            readLock.lock();
            return (String) caChe.get(key);
        } catch (Exception e) {
            return "";

        } finally {
            readLock.unlock();
        }
    }
}


