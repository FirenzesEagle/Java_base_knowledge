package me.liumingbo.designPattern.proxyAndDecoratorPattern.decorator;

import me.liumingbo.designPattern.proxyAndDecoratorPattern.subject.ISubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class SubjectPreDecorator implements ISubject {
    private static Logger logger = LoggerFactory.getLogger(SubjectPreDecorator.class);

    private ISubject subject;

    public SubjectPreDecorator(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        preAction();
        subject.action();
    }

    private void preAction() {
        logger.info("SubjectPreDecorator.preAction()");
    }

}
