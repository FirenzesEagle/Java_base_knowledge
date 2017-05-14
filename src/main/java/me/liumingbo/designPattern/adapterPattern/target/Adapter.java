package me.liumingbo.designPattern.adapterPattern.target;

import me.liumingbo.designPattern.adapterPattern.adaptee.Adaptee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 适配器，传入待适配对象的引用
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Adapter implements ITarget {

    private static Logger logger = LoggerFactory.getLogger(Adapter.class);

    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        logger.info("Adapter.request");
        adaptee.onRequest();
    }

}
