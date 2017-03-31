package me.liumingbo.threads.threadlocal;

/**
 * 因为initialValue()方法默认返回的是null，所以如果没有set直接get的话会报空指针异常
 *
 * Created by FirenzesEagle on 2016/12/13.
 * Email:liumingbo2008@gmail.com
 */
public class UnSetThreadLocalTest {
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
        final UnSetThreadLocalTest unSetThreadLocalTest = new UnSetThreadLocalTest();
        System.out.println(unSetThreadLocalTest.getLong());
        System.out.println(unSetThreadLocalTest.getString());

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                unSetThreadLocalTest.set();
                System.out.println(unSetThreadLocalTest.getLong());
                System.out.println(unSetThreadLocalTest.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(unSetThreadLocalTest.getLong());
        System.out.println(unSetThreadLocalTest.getString());
    }
}
