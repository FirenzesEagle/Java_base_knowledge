package me.liumingbo.designPattern.dynamicProxy.proxy.jdkProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * SubjectProxyHandler定义的是代理行为而非代理类本身，
 * 实际上代理类及其实例是在运行时通过反射动态创建出来的。
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class SubjectProxyHandler implements InvocationHandler {

    private static Logger logger = LoggerFactory.getLogger(SubjectProxyHandler.class);

    private Object target;

    public SubjectProxyHandler(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("Create proxy for {} failed", clazz.getName());
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preAction();
        Object result = method.invoke(target, args);
        postAction();
        logger.info("Proxy class name {}", proxy.getClass().getName());
        return result;
    }

    private void preAction() {
        logger.info("SubjectProxyHandler.preAction()");
    }

    private void postAction() {
        logger.info("SubjectProxyHandler.postAction()");
    }
}
