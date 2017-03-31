package me.liumingbo.designPattern.simpleFactoryPattern.client;

import me.liumingbo.designPattern.simpleFactoryPattern.factory.CarFactory3;
import me.liumingbo.designPattern.simpleFactoryPattern.product.Car;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class Driver5 {
    public static void main(String[] args) {
        Car car = CarFactory3.newCar();
        car.drive();
    }
}
