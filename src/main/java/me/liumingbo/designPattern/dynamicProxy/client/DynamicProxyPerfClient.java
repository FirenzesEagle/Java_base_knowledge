package me.liumingbo.designPattern.dynamicProxy.client;

import me.liumingbo.designPattern.dynamicProxy.proxy.cglibProxy.SubjectInterceptor;
import me.liumingbo.designPattern.dynamicProxy.proxy.jdkProxy.SubjectProxyHandler;
import me.liumingbo.designPattern.dynamicProxy.subject.ConcreteSubject;
import me.liumingbo.designPattern.dynamicProxy.subject.ISubject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理与cglib对比
   字节码创建方式：JDK动态代理通过JVM实现代理类字节码的创建，cglib通过ASM创建字节码
   对被代理对象的要求：JDK动态代理要求被代理对象实现接口，cglib要求被代理对象未被final修饰
   代理对象创建速度：JDK动态代理创建代理对象速度比cglib快
   代理对象执行速度：JDK动态代理代理对象执行速度比cglib快
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class DynamicProxyPerfClient {

    private static final Logger LOG = LoggerFactory.getLogger(DynamicProxyPerfClient.class);
    private static int creation = 100000000;
    private static int execution = 1000000000;

    public static void main(String[] args) throws IOException {
        testJDKDynamicCreation();
        testJDKDynamicExecution();
        testCglibCreation();
        testCglibExecution();
    }

    private static void testJDKDynamicCreation() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < creation; i++) {
            InvocationHandler handler = new SubjectProxyHandler(ConcreteSubject.class);
            Proxy.newProxyInstance(DynamicProxyPerfClient.class.getClassLoader(),
                    new Class[] {ISubject.class}, handler);
        }
        long stop = System.currentTimeMillis();
        LOG.info("JDK creation time : {} ms", stop - start);
    }

    private static void testJDKDynamicExecution() {
        long start = System.currentTimeMillis();
        InvocationHandler handler = new SubjectProxyHandler(ConcreteSubject.class);
        ISubject subject =
                (ISubject) Proxy.newProxyInstance(DynamicProxyPerfClient.class.getClassLoader(),
                        new Class[] {ISubject.class}, handler);
        for (int i = 0; i < execution;
             i++) {
            subject.action();
        }
        long stop = System.currentTimeMillis();
        LOG.info("JDK execution time : {} ms", stop - start);
    }

    private static void testCglibCreation() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < creation; i++) {
            MethodInterceptor methodInterceptor = new SubjectInterceptor();
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(ConcreteSubject.class);
            enhancer.setCallback(methodInterceptor);
            enhancer.create();
        }
        long stop = System.currentTimeMillis();
        LOG.info("cglib creation time : {} ms", stop - start);
    }

    private static void testCglibExecution() {
        MethodInterceptor methodInterceptor = new SubjectInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteSubject.class);
        enhancer.setCallback(methodInterceptor);
        ISubject subject = (ISubject) enhancer.create();
        long start = System.currentTimeMillis();
        for (int i = 0; i < execution; i++) {
            subject.action();
        }
        long stop = System.currentTimeMillis();
        LOG.info("cglib execution time : {} ms", stop - start);
    }

}
