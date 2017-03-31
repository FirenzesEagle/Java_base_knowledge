package me.liumingbo.designPattern.simpleFactoryPattern.client;

import me.liumingbo.designPattern.simpleFactoryPattern.factory.CarFactory2;
import me.liumingbo.designPattern.simpleFactoryPattern.product.Car;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class Driver4 {
    public static void main(String[] args) {
        Car car = CarFactory2.newCar();
        car.drive();
    }
}
