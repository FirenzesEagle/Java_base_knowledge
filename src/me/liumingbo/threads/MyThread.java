package me.liumingbo.threads;

/**
 * Created by FirenzesEagle on 2016/12/7.
 * Email:liumingbo2008@gmail.com
 */
public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:" + name + " 子线程ID:" + Thread.currentThread().getId());
    }

}
