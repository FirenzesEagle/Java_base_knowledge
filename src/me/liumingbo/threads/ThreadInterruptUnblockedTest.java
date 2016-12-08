package me.liumingbo.threads;

/**
 * while循环会一直运行直到变量i的值超出Integer.MAX_VALUE。所以说直接调用interrupt方法不能中断正在运行中的线程
 *
 * Created by FirenzesEagle on 2016/12/8.
 * Email:liumingbo2008@gmail.com
 */
public class ThreadInterruptUnblockedTest {
    public static void main(String[] args) {
        ThreadInterruptUnblockedTest threadInterruptUnblockedTest = new ThreadInterruptUnblockedTest();
        MyThread thread = threadInterruptUnblockedTest.new MyThread();
        thread.start();
        try {
            System.out.println("进入线程：" + Thread.currentThread().getName());
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                System.out.println(i + " while循环");
                i++;
            }
        }
    }
}
