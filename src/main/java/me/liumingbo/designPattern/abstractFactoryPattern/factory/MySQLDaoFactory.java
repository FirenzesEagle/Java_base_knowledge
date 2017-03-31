package me.liumingbo.designPattern.abstractFactoryPattern.factory;

import me.liumingbo.designPattern.abstractFactoryPattern.dao.product.IProductDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.product.MySQLProductDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.role.IRoleDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.role.MySQLRoleDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.user.IUserDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.user.MySQLUserDao;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class MySQLDaoFactory implements IDaoFactory {
    @Override
    public IUserDao createUserDao() {
        return new MySQLUserDao();
    }

    @Override
    public IRoleDao createRoleDao() {
        return new MySQLRoleDao();
    }

    @Override
    public IProductDao createProductDao() {
        return new MySQLProductDao();
    }
}
