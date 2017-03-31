package me.liumingbo.designPattern.simpleFactoryPattern.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class JDBC {
    private static Logger logger = LoggerFactory.getLogger(JDBC.class);

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            connection = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/default");
            PreparedStatement ps = connection.prepareStatement("select count(*) from test.test");
            ps.execute();
        } catch (ClassNotFoundException e) {
            logger.warn("Load Hive driver failed", e);
        } catch (SQLException e) {
            logger.warn("Execute query failed", e);
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
