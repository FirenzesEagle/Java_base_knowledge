package me.liumingbo.threads.base;

/**
 * Created by liumingbo on 2016/12/7.
 * Email:liumingbo2008@gmail.com
 */
public class MyRunnable implements Runnable {
    public MyRunnable() {
    }

    @Override
    public void run() {
        System.out.println("子线程ID："+Thread.currentThread().getId());
    }
}
