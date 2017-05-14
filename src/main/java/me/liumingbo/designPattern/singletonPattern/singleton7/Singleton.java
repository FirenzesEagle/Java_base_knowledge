package me.liumingbo.designPattern.singletonPattern.singleton7;

/**
 * 静态内部类 推荐
 * <p>
 * 优点：无线程同步问题，实现了懒加载（Lazy Loading）。因为只有调用getInstance时才会装载内部类，才会创建实例
 * 缺点：NA
 * <p>
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Singleton {

    private Singleton() {

    }

    public static Singleton getInstance() {
        return InnerClass.instance;
    }

    private static class InnerClass {
        private static final Singleton instance = new Singleton();
    }

}
