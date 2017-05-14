package me.liumingbo.designPattern.flyweightPattern.flyweight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class ConcreteFlyWeight implements FlyWeight {

    private static Logger logger = LoggerFactory.getLogger(ConcreteFlyWeight.class);

    private String name;

    public ConcreteFlyWeight(String name) {
        this.name = name;
    }

    @Override
    public void action(String externalState) {
        logger.info("name = {}, outerState = {}", this.name, externalState);
    }
}
