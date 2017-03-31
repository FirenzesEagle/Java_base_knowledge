package me.liumingbo.designPattern.factoryMethodPattern.factory;

import me.liumingbo.designPattern.factoryMethodPattern.dao.IUserDao;
import me.liumingbo.designPattern.factoryMethodPattern.dao.PostgreSQLUserDao;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class PostgreSQLDaoFactory implements IDaoFactory {
    @Override
    public IUserDao createUserDao() {
        return new PostgreSQLUserDao();
    }
}
