package me.liumingbo.designPattern.singletonPattern.singleton6;

/**
 * 静态代码块 饿汉 - 可用
 * <p>
 * 优点：无线程同步问题
 * 缺点：类装载时创建实例，无Lazy Loading。实例一直未被使用时，会浪费资源
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Singleton {

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}
