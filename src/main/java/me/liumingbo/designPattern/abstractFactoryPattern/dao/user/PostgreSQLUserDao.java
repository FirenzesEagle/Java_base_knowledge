package me.liumingbo.designPattern.abstractFactoryPattern.dao.user;

import me.liumingbo.designPattern.abstractFactoryPattern.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class PostgreSQLUserDao implements IUserDao {
    private static Logger logger = LoggerFactory.getLogger(PostgreSQLUserDao.class);

    @Override
    public void addUser(User user) {
        logger.info("PostgreSQL added User {}", user);
    }

    @Override
    public void removeUser(User user) {
        logger.info("PostgreSQL removed User {}", user);
    }

    @Override
    public User getUser(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
