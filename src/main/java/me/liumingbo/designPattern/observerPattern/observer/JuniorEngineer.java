package me.liumingbo.designPattern.observerPattern.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class JuniorEngineer implements ITalent {
    private Logger logger = LoggerFactory.getLogger(JuniorEngineer.class);

    @Override
    public void newJob(String job) {
        logger.info("Junior engineer get new position {}", job);
    }
}
