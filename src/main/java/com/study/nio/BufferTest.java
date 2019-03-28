package com.study.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @description buffer测试
 * @date 2019/3/12
 */
public class BufferTest  {

@Test
    public void  bufferTest(){
        ByteBuffer byteBuffer=ByteBuffer.allocate(10);

    byteBuffer.put("abcd".getBytes());
    byteBuffer.flip();
    byte[] bytes1=  new byte[byteBuffer.limit()];

    byteBuffer.get(bytes1,0,2);
    System.out.println(new String(bytes1,0,2));
    System.out.println(byteBuffer.position());
    //整个缓存区可用的大小
   ;
}

}
