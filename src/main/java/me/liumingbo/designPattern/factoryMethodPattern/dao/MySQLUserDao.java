package me.liumingbo.designPattern.factoryMethodPattern.dao;

import me.liumingbo.designPattern.factoryMethodPattern.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class MySQLUserDao implements IUserDao {
    private static Logger logger = LoggerFactory.getLogger(MySQLUserDao.class);

    @Override
    public void addUser(User user) {
        logger.info("MySQL added User {}", user);
    }

    @Override
    public void removeUser(User user) {
        logger.info("MySQL removed User {}", user);
    }

    @Override
    public User getUser(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
