package me.liumingbo.Threads;

/**
 * Created by FirenzesEagle on 2016/12/7.
 * Email:liumingbo2008@gmail.com
 */
public class MyThread extends Thread {
    private static int num = 0;

    public MyThread(){
        num++;
    }
    @Override
    public void run(){
        System.out.println("主动创建的第"+ num + "个线程");
    }

}
