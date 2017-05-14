package me.liumingbo.designPattern.singletonPattern.singleton1;

/**
 * 线程不安全的懒汉 - 多线程不可用
 *
 * 优点：达到了Lazy Loading的效果
   缺点：只有在单线程下能保证只有一个实例，多线程下有创建多个实例的风险
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
