package me.liumingbo.designPattern.simpleFactoryPattern.factory;

import me.liumingbo.designPattern.simpleFactoryPattern.product.Car;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class CarFactory2 {
    private static Logger logger = LoggerFactory.getLogger(CarFactory2.class);

    public static Car newCar(){
        Car car = null;
        String name = null;
        Configurations configurations = new Configurations();
        try {
            XMLConfiguration config = configurations.xml("car.xml");
            name = config.getString("factory2.class");
        } catch (ConfigurationException e) {
            logger.error("parse xml configuration file failed", e);
        }

        try {
            car = (Car) Class.forName(name).newInstance();
            logger.info("Created car class name is {}", name);
        } catch (InstantiationException e) {
            logger.error("Instantiate car {} failed", name);
        } catch (IllegalAccessException e) {
            logger.error("Instantiate car {} failed", name);
        } catch (ClassNotFoundException e) {
            logger.error("Instantiate car {} failed", name);
        }
        return car;
    }
}
