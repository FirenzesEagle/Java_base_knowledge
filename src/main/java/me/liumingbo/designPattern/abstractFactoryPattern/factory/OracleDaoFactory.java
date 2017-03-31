package me.liumingbo.designPattern.abstractFactoryPattern.factory;

import me.liumingbo.designPattern.abstractFactoryPattern.dao.product.IProductDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.product.OracleProductDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.role.IRoleDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.role.OracleRoleDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.user.IUserDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.user.OracleUserDao;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class OracleDaoFactory implements IDaoFactory {
    @Override
    public IUserDao createUserDao() {
        return new OracleUserDao();
    }

    @Override
    public IRoleDao createRoleDao() {
        return new OracleRoleDao();
    }

    @Override
    public IProductDao createProductDao() {
        return new OracleProductDao();
    }
}
