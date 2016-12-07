package me.liumingbo.threads;

/**
 * Created by liumingbo on 2016/12/8.
 * Email:liumingbo2008@gmail.com
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        System.out.println("进入线程："+Thread.currentThread().getName());
        ThreadJoinTest threadJoinTest = new ThreadJoinTest();
        MyThread thread1 = threadJoinTest.new MyThread();
        thread1.start();
        try {
            System.out.println("线程："+Thread.currentThread().getName()+"等待");
            thread1.join();
            System.out.println("线程："+Thread.currentThread().getName()+"继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("进入线程："+Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程："+Thread.currentThread().getName()+"执行完毕");
        }
    }
}
