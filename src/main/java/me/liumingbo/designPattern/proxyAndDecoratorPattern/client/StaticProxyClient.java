package me.liumingbo.designPattern.proxyAndDecoratorPattern.client;

import me.liumingbo.designPattern.proxyAndDecoratorPattern.proxy.ProxySubject;
import me.liumingbo.designPattern.proxyAndDecoratorPattern.subject.ISubject;

/**
 * Created by bjliumingbo on 2017/4/7.
 */
public class StaticProxyClient {
    public static void main(String[] args) {
        ISubject subject = new ProxySubject();
        subject.action();
    }
}
