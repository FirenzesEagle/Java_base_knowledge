package me.liumingbo.designPattern.proxyAndDecoratorPattern.proxy;

import me.liumingbo.designPattern.proxyAndDecoratorPattern.subject.ConcreteSubject;
import me.liumingbo.designPattern.proxyAndDecoratorPattern.subject.ISubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class ProxySubject implements ISubject {
    private static Logger logger = LoggerFactory.getLogger(ProxySubject.class);

    private ISubject iSubject;

    public ProxySubject() {
        iSubject = new ConcreteSubject();
    }

    @Override
    public void action() {
        preAction();
        if (new Random().nextBoolean()) {
            iSubject.action();
        } else {
            logger.info("Permission denied");
        }
        postAction();
    }

    private void preAction() {
        logger.info("ProxySubject.preAction()");
    }

    private void postAction() {
        logger.info("ProxySubject.postAction()");
    }
}
