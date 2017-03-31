package me.liumingbo.designPattern.factoryMethodPattern.client;

import me.liumingbo.designPattern.factoryMethodPattern.dao.IUserDao;
import me.liumingbo.designPattern.factoryMethodPattern.factory.IDaoFactory;
import me.liumingbo.designPattern.factoryMethodPattern.factory.MySQLDaoFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class Client {
    public static void main(String[] args) {
        IDaoFactory factory = new MySQLDaoFactory();
        IUserDao userDao = factory.createUserDao();
        userDao.getUser("admin");
    }
}
