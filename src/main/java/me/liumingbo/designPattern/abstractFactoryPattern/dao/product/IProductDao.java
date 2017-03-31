package me.liumingbo.designPattern.abstractFactoryPattern.dao.product;

import me.liumingbo.designPattern.abstractFactoryPattern.bean.Product;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public interface IProductDao {
    void addProduct(Product product);

    void removeProduct(Product product);

    Product getProduct(String productname);
}
