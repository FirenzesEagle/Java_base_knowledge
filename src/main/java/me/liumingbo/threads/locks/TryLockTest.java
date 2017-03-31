package me.liumingbo.threads.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class TryLockTest {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final TryLockTest tryLockTest = new TryLockTest();
        new Thread() {
            @Override
            public void run() {
                tryLockTest.insert(Thread.currentThread());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                tryLockTest.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "得到了锁");
                thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            } finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName() + "获取锁失败");
        }
    }
}
