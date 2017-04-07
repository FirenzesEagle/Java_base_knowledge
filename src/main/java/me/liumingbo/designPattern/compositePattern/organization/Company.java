package me.liumingbo.designPattern.compositePattern.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class Company extends Organization {
    private static Logger logger = LoggerFactory.getLogger(Company.class);

    public Company(String name) {
        super(name);
    }

    @Override
    public void inform(String info) {
        logger.info("{}-{}", info, getName());
        List<Organization> allOrgs = getAllOrgs();
        for (Organization org : allOrgs) {
            org.inform(info + "-");
        }
    }
}
