package me.liumingbo.threads.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
 * 如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁。
 *
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class ReadWriteLockTest {
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();

        new Thread() {
            @Override
            public void run() {
                readWriteLockTest.get(Thread.currentThread());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                readWriteLockTest.get(Thread.currentThread());
            }
        }.start();
    }

    public void get(Thread thread) {
        reentrantReadWriteLock.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
