package me.liumingbo.designPattern.dynamicProxy.proxy.staticProxy;

import me.liumingbo.designPattern.dynamicProxy.subject.ISubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 动态代理实际的代理类
 * <p>
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class $Proxy17 extends Proxy implements ISubject {
    private static Method m1;
    private static Method m2;
    private static Method m0;
    private static Method m3;

    public $Proxy17(InvocationHandler paramInvocationHandler) {
        super(paramInvocationHandler);
    }

    public final boolean equals(Object paramObject) {
        try {
            return ((Boolean) this.h.invoke(this, m1, new Object[]{paramObject})).booleanValue();
        } catch (Error | RuntimeException localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final String toString() {
        try {
            return (String) this.h.invoke(this, m2, null);
        } catch (Error | RuntimeException localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final int hashCode() {
        try {
            return ((Integer) this.h.invoke(this, m0, null)).intValue();
        } catch (Error | RuntimeException localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final void action() {
        try {
            this.h.invoke(this, m3, null);
            return;
        } catch (Error | RuntimeException localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", new Class[]{Class.forName("java.lang.Object")});
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            m3 = Class.forName("me.liumingbo.designPattern.dynamicProxy.subject.ISubject").getMethod("action", new Class[0]);
        } catch (NoSuchMethodException localNoSuchMethodException) {
            throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
        }
    }
}
