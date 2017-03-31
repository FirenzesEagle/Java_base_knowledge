package me.liumingbo.designPattern.abstractFactoryPattern.dao.user;


import me.liumingbo.designPattern.abstractFactoryPattern.bean.User;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public interface IUserDao {
    void addUser(User user);

    void removeUser(User user);

    User getUser(String username);
}
