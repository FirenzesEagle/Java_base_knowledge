package me.liumingbo.designPattern.compositePattern.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class Department extends Organization {
    private static Logger logger = LoggerFactory.getLogger(Department.class);

    public Department(String name) {
        super(name);
    }

    @Override
    public void inform(String info) {
        logger.info("{}-{}", info, getName());
    }
}
