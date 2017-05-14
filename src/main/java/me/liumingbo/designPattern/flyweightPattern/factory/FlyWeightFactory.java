package me.liumingbo.designPattern.flyweightPattern.factory;

import me.liumingbo.designPattern.flyweightPattern.flyweight.ConcreteFlyWeight;
import me.liumingbo.designPattern.flyweightPattern.flyweight.FlyWeight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class FlyWeightFactory {

    private static Logger logger = LoggerFactory.getLogger(FlyWeightFactory.class);

    private static ConcurrentHashMap<String, FlyWeight> allFlyWeight = new ConcurrentHashMap<String, FlyWeight>();

    public static FlyWeight getFlyWeight(String name) {
        if (allFlyWeight.get(name) == null) {
            synchronized (allFlyWeight) {
                if (allFlyWeight.get(name) == null) {
                    logger.info("Instance of name = {} does not exist, creating it", name);
                    FlyWeight flyWeight = new ConcreteFlyWeight(name);
                    logger.info("Instance of name = {} created", name);
                    allFlyWeight.put(name, flyWeight);
                }
            }
        }
        return allFlyWeight.get(name);
    }

}
