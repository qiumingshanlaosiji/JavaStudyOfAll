import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.javaStudy.basicPratice.collection.list.ArraylistTest;
import com.javaStudy.thread.AaaTest;
import com.study.innerClass.InnerClassTest;
import com.javaStudy.thread.FutureTest;
import com.study.thread.Test;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.misc.GC;

import java.io.*;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws Exception {

     Integer[] a=new Integer[]{1,2,3,4};
   List list=  Arrays.asList(a);
        System.out.println(list.get(0));
    }

    private  static Predicate<Integer> aaaa(){

        return  p->p>2;
    }

    private  static  Predicate<AAAA> aaa23(){

        return  p->p.getName().equals("asd");
    }
    private static void test22() throws Exception {
        reentrantLock.lock();
        Thread.sleep(30000);
        System.out.println(111);
        reentrantLock.unlock();
    }

    private static void test221() throws Exception {
        System.out.println(123);
        //reentrantLock.tryLock(2,TimeUnit.SECONDS);
        System.out.println(1112);
        //reentrantLock.unlock();
    }

    private static void test1() throws Exception {
        ArrayList<Integer> arrayBlockingQueue = new ArrayList<>(10);
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {

            new Thread(() -> {
                try {
                    arrayBlockingQueue.add(1);
                    countDownLatch.countDown();

                } catch (Exception e) {

                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(arrayBlockingQueue.size());
    }

    private static void test() throws Exception {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                try {
                    Thread.sleep(5000);
                    arrayBlockingQueue.add(1);
                    countDownLatch.countDown();

                } catch (Exception e) {

                }
            }).start();
        }
        countDownLatch.await();
        for (int i = 0; i < arrayBlockingQueue.size(); i++) {
            System.out.println(arrayBlockingQueue.peek());
        }
    }

}

class  AAAA{

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
