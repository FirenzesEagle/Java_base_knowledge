package me.liumingbo.threads.locks;

/**
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class SyncReadWriteTest {
    public static void main(String[] args) {
        final SyncReadWriteTest syncReadWriteTest = new SyncReadWriteTest();

        new Thread() {
            @Override
            public void run() {
                syncReadWriteTest.get(Thread.currentThread());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                syncReadWriteTest.get(Thread.currentThread());
            }
        }.start();
    }

    public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName() + "正在进行读操作");
        }
        System.out.println(thread.getName() + "读操作完毕");
    }
}
