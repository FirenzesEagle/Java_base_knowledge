package me.liumingbo.designPattern.bridgePattern.brand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class LandRoverCar extends AbstractCar {

    private static Logger logger = LoggerFactory.getLogger(LandRoverCar.class);

    @Override
    public void run() {
        gear.gear();
        logger.info("LandRoverCar is running");
    }
}
