package me.liumingbo.designPattern.simpleFactoryPattern.client;

import me.liumingbo.designPattern.simpleFactoryPattern.factory.CarFactory1;
import me.liumingbo.designPattern.simpleFactoryPattern.product.Car;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class Driver3 {
    public static void main(String[] args) {
        Car car = CarFactory1.newCar();
        car.drive();
    }
}
