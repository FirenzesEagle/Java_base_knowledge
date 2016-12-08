package me.liumingbo.threads;

/**
 * 假如在main线程中，调用thread.join方法，则main方法会等待thread线程执行完毕或者等待一定的时间。
 * 如果调用的是无参join方法，则等待thread执行完毕，如果调用的是指定了时间参数的join方法，则等待一定的时间。
 * join方法会让线程释放对一个对象持有的锁
 *
 * Created by liumingbo on 2016/12/8.
 * Email:liumingbo2008@gmail.com
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        System.out.println("进入线程：" +Thread.currentThread().getName());
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
