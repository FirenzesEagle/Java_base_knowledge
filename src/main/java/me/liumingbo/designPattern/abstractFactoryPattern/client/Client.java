package me.liumingbo.designPattern.abstractFactoryPattern.client;

import me.liumingbo.designPattern.abstractFactoryPattern.bean.Product;
import me.liumingbo.designPattern.abstractFactoryPattern.bean.User;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.product.IProductDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.role.IRoleDao;
import me.liumingbo.designPattern.abstractFactoryPattern.dao.user.IUserDao;
import me.liumingbo.designPattern.abstractFactoryPattern.factory.IDaoFactory;
import me.liumingbo.designPattern.abstractFactoryPattern.factory.MySQLDaoFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class Client {
    public static void main(String[] args) {
        IDaoFactory factory = new MySQLDaoFactory();

        IUserDao userDao = factory.createUserDao();
        User user = new User();
        user.setUsername("demo");
        user.setPassword("demo".toCharArray());
        userDao.addUser(user);

        IRoleDao roleDao = factory.createRoleDao();
        roleDao.getRole("admin");

        IProductDao productDao = factory.createProductDao();
        Product product = new Product();
        productDao.removeProduct(product);
    }
}
