package me.liumingbo.designPattern.singletonPattern.singleton3;

/**
 * 同步代码块下的懒汉 - 不可用
 *
 * 优点：不需要在每次调用时加锁，效率比上一个高
   缺点：虽然使用了synchronized，但本质上是线程不安全的。
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }

}
