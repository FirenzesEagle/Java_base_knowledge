package me.liumingbo.designPattern.dynamicProxy.client;

import me.liumingbo.designPattern.dynamicProxy.proxy.staticProxy.ProxySubject;
import me.liumingbo.designPattern.dynamicProxy.subject.ISubject;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class StaticProxyClient {
    public static void main(String[] args) {
        ISubject subject = new ProxySubject();
        subject.action();
    }
}
