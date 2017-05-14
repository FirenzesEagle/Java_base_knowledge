package me.liumingbo.designPattern.adapterPattern.target;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 目标接口实现
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class ConcreteTarget implements ITarget {

    private static Logger logger = LoggerFactory.getLogger(ConcreteTarget.class);

    @Override
    public void request() {
        logger.info("ConcreteTarget.request()");
    }
}
