package me.liumingbo.threads.base;

import java.io.IOException;

/**
 * 调用interrupt方法相当于将中断标志位置为true，可以通过调用isInterrupted()判断中断标志是否被置位来中断线程的执行。
 *
 * Created by FirenzesEagle on 2016/12/8.
 * Email:liumingbo2008@gmail.com
 */
public class ThreadIsInterruptTest {
    public static void main(String[] args) throws IOException {
        ThreadIsInterruptTest test = new ThreadIsInterruptTest();
        MyThread thread = test.new MyThread();
        thread.start();
        try {
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
            while (!isInterrupted() && i < Integer.MAX_VALUE) {
                System.out.println(i + " while循环");
                i++;
            }
        }
    }
}
