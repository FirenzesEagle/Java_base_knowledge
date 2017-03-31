package me.liumingbo.designPattern.abstractFactoryPattern.factory;

import me.liumingbo.designPattern.abstractFactoryPattern.dao.product.IProductDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.product.PostgreSQLProductDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.role.IRoleDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.role.PostgreSQLRoleDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.user.IUserDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.user.PostgreSQLUserDao;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class PostgreSQLDaoFactory implements IDaoFactory {
    @Override
    public IUserDao createUserDao() {
        return new PostgreSQLUserDao();
    }

    @Override
    public IRoleDao createRoleDao() {
        return new PostgreSQLRoleDao();
    }

    @Override
    public IProductDao createProductDao() {
        return new PostgreSQLProductDao();
    }
}
