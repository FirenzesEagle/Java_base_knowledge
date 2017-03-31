package me.liumingbo.threads.base;

/**
 * Created by FirenzesEagle on 2016/12/9.
 * Email:liumingbo2008@gmail.com
 */
public class ThreadIsStopTest {
    public static void main(String[] args) {
        ThreadIsStopTest threadIsStopTest = new ThreadIsStopTest();
        MyThread thread = threadIsStopTest.new MyThread();
        thread.start();
        try {
            System.out.println("当前线程为：" + Thread.currentThread().getName());
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.setStop(true);
    }

    class MyThread extends Thread{
        private volatile boolean isStop = false;
        @Override
        public void run() {
            int i = 0;
            while(!isStop){
                System.out.println(i + " while循环");
                i++;
            }
        }

        public void setStop(boolean stop){
            this.isStop = stop;
        }
    }
}
