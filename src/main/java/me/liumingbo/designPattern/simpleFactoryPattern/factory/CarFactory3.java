package me.liumingbo.designPattern.simpleFactoryPattern.factory;

import me.liumingbo.designPattern.simpleFactoryPattern.annotation.Vehicle;
import me.liumingbo.designPattern.simpleFactoryPattern.product.Car;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class CarFactory3 {
    private static Logger logger = LoggerFactory.getLogger(CarFactory3.class);

    private static Map<String, Class> allCars;

    static {
        Reflections reflections = new Reflections("me.liumingbo.designPattern.simpleFactoryPattern.product");
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Vehicle.class);
        allCars = new ConcurrentHashMap<String, Class>();
        for (Class<?> classObject : annotatedClasses) {
            Vehicle vehicle = classObject.getAnnotation(Vehicle.class);
            allCars.put(vehicle.type(), classObject);
        }
        allCars = Collections.unmodifiableMap(allCars);
    }

    public static Car newCar() {
        Car car = null;
        String type = null;
        Configurations configurations = new Configurations();
        try {
            XMLConfiguration config = configurations.xml("car.xml");
            type = config.getString("factory3.type");
            logger.info("car type is {}", type);
        } catch (ConfigurationException e) {
            logger.error("Parsing xml configuration file failed", e);
        }
        if (allCars.containsKey(type)){
            logger.info("Created car type is {}", type);
            try {
                car = (Car) allCars.get(type).newInstance();
            } catch (InstantiationException e) {
                logger.error("Instantiate car failed", e);
            } catch (IllegalAccessException e) {
                logger.error("Instantiate car failed", e);
            }
        }
        return car;
    }
}
