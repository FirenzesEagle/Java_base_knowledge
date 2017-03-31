package me.liumingbo.designPattern.observerPattern.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class SeniorEngineer implements ITalent {
    private static Logger logger = LoggerFactory.getLogger(SeniorEngineer.class);

    @Override
    public void newJob(String job) {
        logger.info("Senior engineer get new position {}", job);
    }
}
