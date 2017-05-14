package me.liumingbo.designPattern.singletonPattern.singleton2;

/**
 * 同步方法下的懒汉 - 可用，不推荐
 *
 * 优点：线程安全，可确保正常使用下（不考虑通过反射调用私有构造方法）只有一个实例
   缺点：每次获取实例都需要申请锁，开销大，效率低
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Singleton {

    private static Singleton instance;

    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
