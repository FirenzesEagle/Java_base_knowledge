package me.liumingbo.designPattern.abstractFactoryPattern.dao.user;

import me.liumingbo.designPattern.abstractFactoryPattern.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class OracleUserDao implements IUserDao {
    private static Logger logger = LoggerFactory.getLogger(OracleUserDao.class);

    @Override
    public void addUser(User user) {
        logger.info("Oracle added User {}", user);
    }

    @Override
    public void removeUser(User user) {
        logger.info("Oracle removed User {}", user);
    }

    @Override
    public User getUser(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
