package me.liumingbo.threads.threadlocal;

/**
 * Created by FirenzesEagle on 2016/12/13.
 * Email:liumingbo2008@gmail.com
 */
public class ThreadLocalTest {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longThreadLocal.get();
    }

    public String getString() {
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.set();
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                threadLocalTest.set();
                System.out.println(threadLocalTest.getLong());
                System.out.println(threadLocalTest.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());
    }

}
