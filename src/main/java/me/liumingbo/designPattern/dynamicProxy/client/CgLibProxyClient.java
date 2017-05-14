package me.liumingbo.designPattern.dynamicProxy.client;

import me.liumingbo.designPattern.dynamicProxy.proxy.cglibProxy.SubjectInterceptor;
import me.liumingbo.designPattern.dynamicProxy.subject.ConcreteSubject;
import me.liumingbo.designPattern.dynamicProxy.subject.ISubject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class CgLibProxyClient {
    public static void main(String[] args) {
        MethodInterceptor methodInterceptor = new SubjectInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteSubject.class);
        enhancer.setCallback(methodInterceptor);
        ISubject subject = (ISubject) enhancer.create();
        subject.action();
    }
}
