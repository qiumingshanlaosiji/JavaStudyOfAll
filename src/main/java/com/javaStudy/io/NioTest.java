package com.javaStudy.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @description
 * @date 2019/3/31
 */
public class NioTest {

    public static void main(String[] args) {

        test3();

    }

    private  static  void  test(){
        CharBuffer charBuffer= CharBuffer.allocate(8);
        System.out.println(charBuffer.limit());
        charBuffer.put('1');
        charBuffer.put('2');
        System.out.println(charBuffer.position());
        charBuffer.flip();//将limit设置为position所在位置 position置0
        System.out.println(charBuffer.position());
        System.out.println(charBuffer.limit());
//        charBuffer.put('3');
//        charBuffer.put('4');
        System.out.println(charBuffer.get());
        System.out.println(charBuffer.get());
      charBuffer.clear();//position和limit置为初始值
        charBuffer.put('7');
        charBuffer.put('7');
        System.out.println(charBuffer.position());
        System.out.println(charBuffer.limit());
        charBuffer.put('7');
        charBuffer.flip();
        System.out.println(charBuffer.get());
        System.out.println(charBuffer.get());
        System.out.println(charBuffer.get()+"dads");
//        charBuffer.put('2');
    }

///channel学习
    private  static  void  test1(){

        File file=new File("");
        //自动释放资源
        try( FileChannel inChannle=new FileInputStream(file).getChannel();

             FileChannel outChannel=new FileOutputStream("").getChannel();) {

            //channel 转换为buffer
            MappedByteBuffer buffer=inChannle.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            //创建Charset
            Charset charset=Charset.forName("GBK");

            outChannel.write(buffer);

            buffer.clear();

            //解码器
            CharsetDecoder decoder=charset.newDecoder();

            CharBuffer charBuffer=decoder.decode(buffer);

            System.out.println(charBuffer);

        }
        catch (Exception e){

        }
    }

    private  static void   test3(){
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String str = "abcd1";
        buf.put(str.getBytes());
        // 开启读取模式
        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        buf.mark();
        System.out.println(new String(dst, 0, 2));
        System.out.println(buf.position());
        buf.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buf.position());
        buf.reset();
        System.out.println("重置恢复到mark位置..");
        System.out.println(buf.position());

    }
}

