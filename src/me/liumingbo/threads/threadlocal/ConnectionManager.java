package me.liumingbo.threads.threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 1. 这里面的2个方法都没有进行同步，很可能在openConnection方法中会多次创建connect；
 * 2. 由于connect是共享变量，那么必然在调用connect的地方需要使用到同步来保障线程安全，因为很可能一个线程在使用connect进行数据库操作，而另外一个线程调用closeConnection关闭链接。
 *
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class ConnectionManager {
    private static Connection connection = null;

    public static Connection openConnection() throws SQLException {
        if (connection ==null){
            connection = DriverManager.getConnection("");
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }
}
