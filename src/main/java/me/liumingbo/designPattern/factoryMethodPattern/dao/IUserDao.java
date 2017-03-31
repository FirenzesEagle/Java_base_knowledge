package me.liumingbo.designPattern.factoryMethodPattern.dao;

import me.liumingbo.designPattern.factoryMethodPattern.bean.User;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public interface IUserDao {
    void addUser(User user);

    void removeUser(User user);

    User getUser(String username);
}
