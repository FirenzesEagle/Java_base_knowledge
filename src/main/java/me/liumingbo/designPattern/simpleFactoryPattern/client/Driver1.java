package me.liumingbo.designPattern.simpleFactoryPattern.client;

import me.liumingbo.designPattern.simpleFactoryPattern.product.BenzCar;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class Driver1 {
    public static void main(String[] args) {
        BenzCar car = new BenzCar();
        car.drive();
    }
}
