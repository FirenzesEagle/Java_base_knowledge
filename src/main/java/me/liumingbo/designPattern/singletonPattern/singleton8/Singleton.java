package me.liumingbo.designPattern.singletonPattern.singleton8;

/**
 * 枚举 不推荐
 * <p>
 * 优点：无线程同步问题，且能防止通过反射创建新的对象
 * 缺点：使用的是枚举，而非类。同时单一实例的访问点也不是一般单例模式的静态方法
 * <p>
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public enum Singleton {

    instance;

    public void whatSoEverMethod() {
    }

}
