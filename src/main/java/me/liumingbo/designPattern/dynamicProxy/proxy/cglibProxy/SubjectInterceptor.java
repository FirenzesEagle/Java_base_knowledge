package me.liumingbo.designPattern.dynamicProxy.proxy.cglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class SubjectInterceptor implements MethodInterceptor {

    private static Logger logger = LoggerFactory.getLogger(SubjectInterceptor.class);

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        preAction();
        Object result = methodProxy.invokeSuper(o, objects);
        postAction();
        logger.info("Proxy class name {}", o.getClass().getName());
        return result;
    }

    private void preAction() {
        logger.info("SubjectProxyHandler.preAction()");
    }

    private void postAction() {
        logger.info("SubjectProxyHandler.postAction()");
    }

}
