package me.liumingbo.designPattern.strategyPattern.context;

import me.liumingbo.designPattern.strategyPattern.strategy.Strategy;
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
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class SimpleFactoryContext {

    private static Logger logger = LoggerFactory.getLogger(SimpleContext.class);
    private static Map<String, Class> allStrategies;

    static {
        Reflections reflections = new Reflections("me.liumingbo.designPattern.strategyPattern.strategy");
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(me.liumingbo.designPattern.strategyPattern.annotation.Strategy.class);
        allStrategies = new ConcurrentHashMap<String, Class>();
        for (Class<?> classObject : annotatedClasses) {
            me.liumingbo.designPattern.strategyPattern.annotation.Strategy strategy = classObject.getAnnotation(me.liumingbo.designPattern.strategyPattern.annotation.Strategy.class);
            allStrategies.put(strategy.name(), classObject);
        }
        allStrategies = Collections.unmodifiableMap(allStrategies);
    }

    private Strategy strategy;

    public SimpleFactoryContext() {
        String name = null;
        Configurations configurations = new Configurations();
        try {
            XMLConfiguration config = configurations.xml("strategy.xml");
            name = config.getString("strategy.name");
            logger.info("strategy name is {}", name);
        } catch (ConfigurationException e) {
            logger.error("Parsing xml configuration file failed", e);
        }
        if (allStrategies.containsKey(name)) {
            logger.info("Created strategy name is {}", name);
            try {
                strategy = (Strategy) allStrategies.get(name).newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                logger.error("Instantiate Strategy failed", ex);
            }
        } else {
            logger.error("Specified Strategy name {} does not exist", name);
        }
    }

    public void action(String input) {
        strategy.strategy(input);
    }
}