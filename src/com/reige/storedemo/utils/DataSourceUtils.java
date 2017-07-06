package com.reige.storedemo.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by REIGE on 2017/7/6.
 */
public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();

    private static final ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static DataSource getDataSource() {
        return dataSource;
    }

    //获取绑定到ThreadLocal 中的 Connection
    public static Connection getConectionByTransaction() throws SQLException {
        Connection connection = tl.get();
        if (connection == null) {
            connection = dataSource.getConnection();
            tl.set(connection);
        }
        return connection;
    }

    //开启事务
    public static void startTransaction(Connection connection) throws SQLException {
        if (connection!=null){
            connection.setAutoCommit(false);
        }
    }

    //事物回滚
    public static void rollback(Connection connection) throws SQLException {
        if (connection!=null){
           connection.rollback();
        }
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection!=null){
            connection.commit();
            connection.close();
            tl.remove();
        }
    }

    /**
     * 当 DBUtils需要手动控制事物时，调用该方法可以获得一个连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
