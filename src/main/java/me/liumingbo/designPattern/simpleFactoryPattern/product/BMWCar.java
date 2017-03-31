package me.liumingbo.designPattern.simpleFactoryPattern.product;

import me.liumingbo.designPattern.simpleFactoryPattern.annotation.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
@Vehicle(type = "BMW")
public class BMWCar extends Car {
    private static Logger logger = LoggerFactory.getLogger(BMWCar.class);

    public BMWCar() {
        this.name = "BMWCar";
    }

    @Override
    public void drive() {
        logger.info("My name is {}. I'm on my way", name);
    }
}
