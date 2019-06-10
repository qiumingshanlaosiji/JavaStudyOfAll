package com.study.thread;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 并发编程框架
 * @date 2018/12/23
 */
public class DisruptorTest {
    public static void main(String[] args) {

// 1.创建一个可缓存的线程 提供线程来出发Consumer 的事件处理
        ExecutorService executor = Executors.newCachedThreadPool();
        // 2.创建工厂
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        // 3.创建ringBuffer 大小
        int ringBufferSize = 1024 * 1024; // ringBufferSize大小一定要是2的N次方
        // 4.创建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(eventFactory, ringBufferSize, executor,
                ProducerType.SINGLE, new YieldingWaitStrategy());
        // 5.连接消费端方法
        disruptor.handleEventsWith(new LongEventHandler());
        // 6.启动
        disruptor.start();
        // 7.创建RingBuffer容器
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        // 8.创建生产者
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        // 9.指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 1; i <= 100; i++) {
            byteBuffer.putLong(0, i);
            producer.onData(byteBuffer);
        }
        //10.关闭disruptor和executor
        disruptor.shutdown();
        executor.shutdown();


    }
}

/*
生产者
 */
class LongEventProducer {

    public final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer) {

        // 1.ringBuffer 事件队列 下一个槽
        long sequence = ringBuffer.next();
        Long data = null;
        try {
            //2.取出空的事件队列
            LongEvent longEvent = ringBuffer.get(sequence);
            data = byteBuffer.getLong(0);
            //3.获取事件队列传递的数据
            longEvent.setValue(data);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } finally {
            System.out.println("生产这准备发送数据");
            //4.发布事件
            ringBuffer.publish(sequence);
        }

    }
}

/*
定义消费者
 */
class LongEventHandler implements EventHandler<LongEvent> {

    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("消费者" + longEvent.getValue());
    }
}


/*
实例化event对象
 */
class LongEventFactory implements EventFactory<LongEvent> {

    public LongEvent newInstance() {
        return new LongEvent();
    }
}

/*
需要传递的数据
 */
 class LongEvent {

    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

