package com.study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @description jdbc学习
 * @date 2019/2/14
 */
public class JdbcTest {

public void  test() throws Exception{

    //1.加载驱动
    Class.forName("com.mysql.jdbc.Driver");
//2.获取连接
    try (  Connection connection= DriverManager.getConnection("","","");
    ){
        //3.创建stattement
        Statement statement=connection.createStatement();


        //4.执行sql
        ResultSet set= statement.executeQuery("");

        //5.获取结果集

        while (set.next()){

        }


    }



}
}
