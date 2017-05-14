package me.liumingbo.designPattern.singletonPattern.singleton4;

/**
 * 双重检查（Double Check）下的懒汉 - 推荐
 *
 * 优点：使用了双重检查，很大程度上避免了线程不安全，同时也避免了不必要的锁开销。
 * 这里要注意，虽然未使用volatile关键字，但是这里的synchronized已经保证了INSTANCE写操作对其它线程读操作的可见性。
   缺点：NA
 *
 * Created by FirenzesEagle on 2017/5/14.
 * Email:liumingbo2008@gmail.com
 */
public class Singleton {

    private static Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
