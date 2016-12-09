package me.liumingbo.threads.locks;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liumingbo on 2016/12/10.
 * Email:liumingbo2008@gmail.com
 */
public class ReentrantLockTest {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread() {
            @Override
            public void run() {
                reentrantLockTest.insert(Thread.currentThread());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                reentrantLockTest.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread) {
        //写在这里不能正确的加锁，原因在于，在insert方法中的lock变量是局部变量，
        // 每个线程执行该方法时都会保存一个副本，那么理所当然每个线程执行到lock.lock()处获取的是不同的锁，所以就不会发生冲突。
//        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }
}
