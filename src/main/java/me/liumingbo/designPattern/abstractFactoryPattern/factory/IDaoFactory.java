package me.liumingbo.designPattern.abstractFactoryPattern.factory;

import me.liumingbo.designPattern.abstractFactoryPattern.dao.product.IProductDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.role.IRoleDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.user.IUserDao;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public interface IDaoFactory {
    IUserDao createUserDao();

    IRoleDao createRoleDao();

    IProductDao createProductDao();
}
