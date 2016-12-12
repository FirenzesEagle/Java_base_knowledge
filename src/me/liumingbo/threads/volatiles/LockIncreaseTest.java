package me.liumingbo.threads.volatiles;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class LockIncreaseTest {
    public volatile int inc = 0;
    public Lock lock = new ReentrantLock();

    public void increase() {
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        final LockIncreaseTest lockIncreaseTest = new LockIncreaseTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        lockIncreaseTest.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {      //保证前面的线程都执行完
            Thread.yield();
        }
        System.out.println(lockIncreaseTest.inc);
    }
}
