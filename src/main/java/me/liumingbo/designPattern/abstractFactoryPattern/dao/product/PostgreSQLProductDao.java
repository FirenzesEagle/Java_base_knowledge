package me.liumingbo.designPattern.abstractFactoryPattern.dao.product;

import me.liumingbo.designPattern.abstractFactoryPattern.bean.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class PostgreSQLProductDao implements IProductDao {
    private static Logger logger = LoggerFactory.getLogger(PostgreSQLProductDao.class);

    @Override
    public void addProduct(Product product) {
        logger.info("PostgreSQL added Product {}", product);
    }

    @Override
    public void removeProduct(Product product) {
        logger.info("PostgreSQL removed Product {}", product);
    }

    @Override
    public Product getProduct(String productname) {
        Product product = new Product();
        product.setProductname(productname);
        return product;
    }
}
