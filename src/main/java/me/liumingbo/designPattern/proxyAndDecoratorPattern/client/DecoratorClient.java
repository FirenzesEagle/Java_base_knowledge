package me.liumingbo.designPattern.proxyAndDecoratorPattern.client;

import me.liumingbo.designPattern.proxyAndDecoratorPattern.decorator.SubjectPostDecorator;
import me.liumingbo.designPattern.proxyAndDecoratorPattern.decorator.SubjectPreDecorator;
import me.liumingbo.designPattern.proxyAndDecoratorPattern.subject.ConcreteSubject;
import me.liumingbo.designPattern.proxyAndDecoratorPattern.subject.ISubject;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class DecoratorClient {
    public static void main(String[] args) {
        ISubject subject = new ConcreteSubject();
        ISubject preDecorator = new SubjectPreDecorator(subject);
        ISubject postDecorator = new SubjectPostDecorator(preDecorator);
        postDecorator.action();
    }
}
