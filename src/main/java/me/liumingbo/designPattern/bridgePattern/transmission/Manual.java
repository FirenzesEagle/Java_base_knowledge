package me.liumingbo.designPattern.bridgePattern.transmission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Manual extends Transmission {

    private static Logger logger = LoggerFactory.getLogger(Manual.class);

    @Override
    public void gear() {
        logger.info("Manual transmission");
    }
}
