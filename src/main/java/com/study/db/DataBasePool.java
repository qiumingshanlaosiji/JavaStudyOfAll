package com.study.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

/**
 * @description 数据库连接池
 * @date 2018/12/26
 * /**
 * * 数据库连接池<br>
 * *
 * * 1.初始化<br>
 * * ####线程池核心容器 空闲线程数、活动线程数<br>
 * * ###构造函数 1.1.1初始化线程,存放在空闲线程池中<br>
 * * 2.获取连接 <br>
 * * ####1.判断存在线程数是否大于最大线程 如果大于最大线程数,则进行等待...<br>
 * * ####2.判断空闲线程数是否大于0 如果空闲线程数<0，创建新的连接<br>
 * * ####3.如果空闲线程数>0，则获取当前空闲线程,存入在活动线程集合中 <br>
 * * 3.释放连接 <br>
 * * ####3.1.1.判断空闲线程数是否大于最大线程数 <br>
 * * ####3.1.2.如果空闲线程数小于最大线程数,将该连接收回到 空闲 线程集合中<br>
 * * ####3.1.3.删除该连接对应的活动线程集合数据<br>
 */
public class DataBasePool {

    private List<Connection> freeConnection = new Vector<Connection>();

    private List<Connection> activeConnection = new Vector<Connection>();

    private static int connCount = 0;

    private DbBean dbBean;

    public DataBasePool(DbBean dbBean) {
        this.dbBean = dbBean;
        init();
    }

    /*
    初始化线程
     */
    private void init() {
        try {
            for (int i = 0; i < dbBean.getInitConnections(); i++) {
                Connection connection = newConnection();
                if (connection != null) {

                    freeConnection.add(connection);

                }

            }

        } catch (Exception e) {

        }
    }


    private Connection newConnection() {
        try {
            Class.forName(dbBean.getDriverName());
            Connection connection = DriverManager.getConnection(dbBean.getUrl(), dbBean.getUserName(), dbBean.getPassword());
            connCount++;
            return connection;

        } catch (Exception e) {
            return null;
        }
    }

    /*
    思路  1.判断是否大于 最大连接数  若超过  那么等待释放  并且回归获取连接
          2.判断空闲连接数是否大于-  若 大于  则从空闲连接数中取连接
          3.如果没有空闲连接数  那么就是创建新的连接
          4.判断连接是否有效  如果有效 那么就加入到活跃连接中
          5.如果无效  那么继续递归
     */
    public Connection getConnection() {
        Connection connection = null;
        try {
            if (connCount < dbBean.getMaxActiveConnections()) {
                if (freeConnection.size() > 0) {
                    connection = freeConnection.remove(0);
                } else {
                    connection = newConnection();
                }
                if (isAvailable(connection)) {
                    activeConnection.add(connection);

                } else {
                    connCount--;
                    connection = getConnection();
                }
            } else {
                wait(dbBean.getConnectionTimeOut());
                connection = getConnection();

            }
        } catch (Exception e) {
            return null;
        }
        return connection;
    }

    private boolean isAvailable(Connection connection) {
        try {
            if (connection == null || connection.isClosed()) {
                return false;
            }
        } catch (Exception e) {

        }
        return true;
    }

    /*
    释放连接池
     */
    public void releaseConnection(Connection connection) throws SQLException {
        if (connection == null) {
            return;
        }
        if (isAvailable(connection)) {
            if (freeConnection.size() < dbBean.getMaxConnections()) {
                freeConnection.add(connection);
            } else {
                //空闲线程数已满
                connection.close();
            }

            activeConnection.remove(connection);
            connCount--;
            notify();
        }
    }
}
