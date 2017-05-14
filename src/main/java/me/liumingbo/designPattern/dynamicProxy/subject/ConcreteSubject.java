package me.liumingbo.designPattern.dynamicProxy.subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class ConcreteSubject implements ISubject {

    private static Logger logger = LoggerFactory.getLogger(ConcreteSubject.class);

    @Override
    public void action() {
        logger.info("action");
    }

}
