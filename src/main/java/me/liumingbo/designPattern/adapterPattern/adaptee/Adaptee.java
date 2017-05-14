package me.liumingbo.designPattern.adapterPattern.adaptee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 待适配类，其接口名为onRequest，而非目标接口request
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Adaptee {

    private static Logger logger = LoggerFactory.getLogger(Adaptee.class);

    public void onRequest() {
        logger.info("Adaptee.onRequest()");
    }
}
