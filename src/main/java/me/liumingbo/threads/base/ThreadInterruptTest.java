package me.liumingbo.threads.base;

/**
 * 单独调用interrupt方法可以使得处于阻塞状态的线程抛出一个异常，也就说，它可以用来中断一个正处于阻塞状态的线程；
 * 另外，通过interrupt方法和isInterrupted()方法来停止正在运行的线程。
 *
 * Created by liumingbo on 2016/12/8.
 * Email:liumingbo2008@gmail.com
 */
public class ThreadInterruptTest {
    public static void main(String[] args) {
        ThreadInterruptTest threadInterruptTest = new ThreadInterruptTest();
        MyThread thread = threadInterruptTest.new MyThread();
        thread.start();
        try {
            thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("进入睡眠状态");
                Thread.currentThread().sleep(10000);
                System.out.println("睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println("得到中断异常");
            }
            System.out.println("run方法执行完毕");
        }
    }
}
