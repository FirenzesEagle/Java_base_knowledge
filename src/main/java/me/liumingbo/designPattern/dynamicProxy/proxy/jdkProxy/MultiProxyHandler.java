package me.liumingbo.designPattern.dynamicProxy.proxy.jdkProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class MultiProxyHandler implements InvocationHandler {

    private static Logger logger = LoggerFactory.getLogger(MultiProxyHandler.class);

    private Object target;

    public MultiProxyHandler(Class clazz) {
        try {
            this.target = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error("Create proxy for {} failed", clazz.getName());
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        switch (method.getName()) {
            case "hashCode":
                return ((int) method.invoke(target, args)) + 1;
            case "equals":
                return (boolean) method.invoke(target, args);
            case "toString":
                return method.invoke(target, args) + "";
            case "action":
                preAction();
                Object result = method.invoke(target, args);
                postAction();
                return result;
            default:
                return method.invoke(target, args);
        }
    }

    private void preAction() {
        logger.info("SubjectProxyHandler.preAction()");
    }

    private void postAction() {
        logger.info("SubjectProxyHandler.postAction()");
    }

}
