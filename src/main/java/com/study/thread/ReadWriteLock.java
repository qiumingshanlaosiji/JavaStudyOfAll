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
  class  ReadWriteLockTest{

    public static void main(String[] args) {
        ReadWriteLock writeLock=new ReadWriteLock();

      new Thread(()->{
          writeLock.get("1");
        }).start();
      new Thread(()->{
            ReadWriteLock writeLock1=new ReadWriteLock();
            writeLock.put("1","1");
        }).start();
        new Thread(()->{
            writeLock.get("1");
        }).start();
        new Thread(()->{
            ReadWriteLock writeLock1=new ReadWriteLock();
            writeLock.put("1","1");
        }).start();

    }
}
public class ReadWriteLock {

    //读写锁
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    //写入锁
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private Map<Object, Object> caChe = new HashMap();

    public void put(String key, String value) {
        try {

            writeLock.lock();
            System.out.println("写入数据");

            Thread.sleep(1000);
            caChe.put(key, value);

        } catch (Exception e) {

        } finally {
            writeLock.unlock();
        }

    }

    public String get(String key) {
        try {
            readLock.lock();
            System.out.println("读取数据");

            Thread.sleep(5000);

            return (String) caChe.get(key);
        } catch (Exception e) {
            return "";

        } finally {
            readLock.unlock();
        }
    }
}


