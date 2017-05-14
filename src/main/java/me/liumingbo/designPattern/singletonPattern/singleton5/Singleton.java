package me.liumingbo.designPattern.singletonPattern.singleton5;

/**
 * 静态常量 饿汉 - 推荐
 * <p>
 * 优点：实现简单，无线程同步问题
 * 缺点：在类装载时完成实例化。若该实例一直未被使用，则会造成资源浪费
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

}
