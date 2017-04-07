package me.liumingbo.designPattern.proxyAndDecoratorPattern.decorator;

import me.liumingbo.designPattern.proxyAndDecoratorPattern.subject.ISubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class SubjectPostDecorator implements ISubject {
    private static Logger logger = LoggerFactory.getLogger(SubjectPostDecorator.class);

    private ISubject subject;

    public SubjectPostDecorator(ISubject subject) {
        this.subject = subject;
    }

    @Override
    public void action() {
        subject.action();
        postAction();
    }

    private void postAction() {
        logger.info("SubjectPostDecorator.preAction()");
    }
}
