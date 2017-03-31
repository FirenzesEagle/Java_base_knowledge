package me.liumingbo.designPattern.abstractFactoryPattern.bean;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class Product {
    private String productname;
    private double price;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productname='" + productname + '\'' +
                ", price=" + price +
                '}';
    }
}
