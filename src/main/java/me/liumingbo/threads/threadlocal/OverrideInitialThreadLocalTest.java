package me.liumingbo.threads.threadlocal;

/**
 * Created by FirenzesEagle on 2016/12/13.
 * Email:liumingbo2008@gmail.com
 */
public class OverrideInitialThreadLocalTest {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        };
    };
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        };
    };

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
        final OverrideInitialThreadLocalTest overrideInitialThreadLocalTest = new OverrideInitialThreadLocalTest();
        System.out.println(overrideInitialThreadLocalTest.getLong());
        System.out.println(overrideInitialThreadLocalTest.getString());

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(overrideInitialThreadLocalTest.getLong());
                System.out.println(overrideInitialThreadLocalTest.getString());
            }
        };
        thread1.start();
        thread1.join();

        System.out.println(overrideInitialThreadLocalTest.getLong());
        System.out.println(overrideInitialThreadLocalTest.getString());
    }
}
