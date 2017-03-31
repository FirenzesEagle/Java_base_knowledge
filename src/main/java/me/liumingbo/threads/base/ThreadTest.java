package me.liumingbo.threads.base;

import java.io.IOException;

/**
 * Created by liumingbo on 2016/12/7.
 * Email:liumingbo2008@gmail.com
 */
public class ThreadTest {
    public static void main(String[] args) throws IOException {
        /*
        * 创建线程
        * */
        System.out.println("主线程ID：" + Thread.currentThread().getId());
//        MyThread thread1 = new MyThread("thread1");
//        thread1.start();
//        MyThread thread2 = new MyThread("thread2");
//        thread2.run();
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
