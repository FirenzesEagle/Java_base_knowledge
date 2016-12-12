package me.liumingbo.threads.volatiles;

/**
 * 运行它会发现每次运行结果都不一致，都是一个小于10000的数字；
 * 因为volatile关键字修饰的变量并不能保证原子性，++操作不是原子性操作。
 *
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class IncreaseTest {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final IncreaseTest increaseTest = new IncreaseTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increaseTest.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {      //保证前面的线程都执行完
            Thread.yield();
        }
        System.out.println(increaseTest.inc);
    }
}
