package me.liumingbo.threads.volatiles;

/**
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class SyncIncreaseTest {
    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final SyncIncreaseTest syncIncreaseTest = new SyncIncreaseTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        syncIncreaseTest.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {      //保证前面的线程都执行完
            Thread.yield();
        }
        System.out.println(syncIncreaseTest.inc);
    }
}
