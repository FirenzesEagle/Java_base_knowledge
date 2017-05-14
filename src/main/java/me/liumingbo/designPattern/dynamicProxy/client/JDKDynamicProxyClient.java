package me.liumingbo.designPattern.dynamicProxy.client;

import me.liumingbo.designPattern.dynamicProxy.proxy.jdkProxy.SubjectProxyHandler;
import me.liumingbo.designPattern.dynamicProxy.subject.ConcreteSubject;
import me.liumingbo.designPattern.dynamicProxy.subject.ISubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class JDKDynamicProxyClient {

    private static Logger logger = LoggerFactory.getLogger(JDKDynamicProxyClient.class);

    public static void main(String[] args) {
        InvocationHandler handler = new SubjectProxyHandler(ConcreteSubject.class);
        ISubject proxy = (ISubject) Proxy.newProxyInstance(JDKDynamicProxyClient.class.getClassLoader(), new Class[]{ISubject.class}, handler);
        logger.info(JDKDynamicProxyClient.class.getClassLoader().toString());
        proxy.action();
    }
}
