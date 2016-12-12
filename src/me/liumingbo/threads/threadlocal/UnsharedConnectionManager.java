package me.liumingbo.threads.threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 由于每次都是在方法内部创建的连接，那么线程之间自然不存在线程安全问题。
 * 但是由于在方法中需要频繁地开启和关闭数据库连接，这样不尽严重影响程序执行效率，还可能导致服务器压力巨大。
 * 这种情况下使用ThreadLocal是再适合不过的了，因为ThreadLocal在每个线程中对该变量会创建一个副本，即每个线程内部都会有一个该变量，
 * 且在线程内部任何地方都可以使用，线程之间互不影响，这样一来就不存在线程安全问题，也不会严重影响程序执行性能。
 *
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class UnsharedConnectionManager {
    private Connection connect = null;

    public Connection openConnection() throws SQLException {
        if (connect == null) {
            connect = DriverManager.getConnection("");
        }
        return connect;
    }

    public void closeConnection() throws SQLException {
        if (connect != null)
            connect.close();
    }
}

class Dao {
    public void insert() throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        Connection connection = connectionManager.openConnection();

        //使用connection进行操作

        connectionManager.closeConnection();
    }
}
