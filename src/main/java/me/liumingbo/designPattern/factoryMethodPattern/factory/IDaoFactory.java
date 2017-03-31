package me.liumingbo.designPattern.factoryMethodPattern.factory;

import me.liumingbo.designPattern.factoryMethodPattern.dao.IUserDao;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public interface IDaoFactory {
    IUserDao createUserDao();
}
