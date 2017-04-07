package me.liumingbo.designPattern.proxyAndDecoratorPattern.subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class ConcreteSubject implements ISubject {
    private static Logger logger = LoggerFactory.getLogger(ConcreteSubject.class);

    @Override
    public void action() {
        logger.info("ConcreteSubject action()");
    }
}
