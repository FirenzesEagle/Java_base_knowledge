package me.liumingbo.designPattern.dynamicProxy.proxy.staticProxy;

import me.liumingbo.designPattern.dynamicProxy.subject.ConcreteSubject;
import me.liumingbo.designPattern.dynamicProxy.subject.ISubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class ProxySubject implements ISubject {

    private static final Logger logger = LoggerFactory.getLogger(ProxySubject.class);

    private ISubject subject;

    public ProxySubject() {
        subject = new ConcreteSubject();
    }

    @Override
    public void action() {
        preAction();
        subject.action();
        postAction();
    }

    public void preAction() {
        logger.info("ProxySubject.preAction()");
    }

    public void postAction() {
        logger.info("ProxySubject.postAction()");
    }

}
