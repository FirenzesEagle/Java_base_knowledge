package me.liumingbo.designPattern.simpleFactoryPattern.factory;

import me.liumingbo.designPattern.simpleFactoryPattern.product.BMWCar;
import me.liumingbo.designPattern.simpleFactoryPattern.product.BenzCar;
import me.liumingbo.designPattern.simpleFactoryPattern.product.Car;
import me.liumingbo.designPattern.simpleFactoryPattern.product.LandRoverCar;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class CarFactory1 {
    private static Logger logger = LoggerFactory.getLogger(CarFactory1.class);

    public static Car newCar() {
        Car car = null;
        String name = null;
        Configurations configurations = new Configurations();
        try {
            XMLConfiguration config = configurations.xml("car.xml");
            name = config.getString("factory1.name");
        } catch (ConfigurationException e) {
            logger.error("parse xml configuration file failed", e);
        }

        switch (name) {
            case "Land Rover":
                car = new LandRoverCar();
                break;
            case "BMW":
                car = new BMWCar();
                break;
            case "Benz":
                car = new BenzCar();
                break;
            default:
                car = null;
                break;
        }
        logger.info("Created car name is {}", name);
        return car;
    }
}
