package me.liumingbo.threads.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在java 1.5的java.util.concurrent.atomic包下提供了一些原子操作类，即对基本数据类型的 自增（加1操作），自减（减1操作）、以及加法操作（加一个数），减法操作（减一个数）进行了封装，
 * 保证这些操作是原子性操作。atomic是利用CAS来实现原子性操作的（Compare And Swap），CAS实际上是利用处理器提供的CMPXCHG指令实现的，而处理器执行CMPXCHG指令是一个原子性操作。
 *
 * Created by FirenzesEagle on 2016/12/12.
 * Email:liumingbo2008@gmail.com
 */
public class AtomicIncreaseTest {
    public AtomicInteger inc = new AtomicInteger();

    public void increase() {
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final AtomicIncreaseTest atomicIncreaseTest = new AtomicIncreaseTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        atomicIncreaseTest.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {      //保证前面的线程都执行完
            Thread.yield();
        }
        System.out.println(atomicIncreaseTest.inc);
    }
}
