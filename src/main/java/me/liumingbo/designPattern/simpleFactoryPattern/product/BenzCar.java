package me.liumingbo.designPattern.simpleFactoryPattern.product;

import me.liumingbo.designPattern.simpleFactoryPattern.annotation.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by FirenzesEagle on 2017/3/30.
 * Email:liumingbo2008@gmail.com
 */
@Vehicle(type = "Benz")
public class BenzCar extends Car {
    private static Logger logger = LoggerFactory.getLogger(BenzCar.class);

    public BenzCar() {
        this.name = "Benz";
    }

    @Override
    public void drive() {
        logger.info("My name is {}. I'm on my way", name);
    }
}
