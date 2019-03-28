package com.study;

import java.io.File;
import java.io.FileReader;

/**
 * @description fiel测试
 * @date 2019/2/14
 */
public class FileTest {

    public static   void  main(String[] args) throws Exception{
        File file=new File("C:\\Users\\30666\\Desktop\\图片报价文件\\协议价汇总1记录 表格.xlsx");
        System.out.println( file.exists());

        FileReader fileReader=new FileReader("C:\\Users\\30666\\Desktop\\图片报价文件\\协议价汇总记录 表格.xlsx");


    }
}
