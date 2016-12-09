package me.liumingbo.threads.synchronizedpack;

/**
 * 如果一个线程执行一个对象的非static synchronized方法，另外一个线程需要执行这个对象所属类的static synchronized方法，此时不会发生互斥现象，
 * 因为访问static synchronized方法占用的是类锁，而访问非static synchronized方法占用的是对象锁，所以不存在互斥现象。
 *
 * Created by FirenzesEagle on 2016/12/9.
 * Email:liumingbo2008@gmail.com
 */
public class StaticSynTest {
    public static void main(String[] args) {
        final StaticSynInsertData staticSynInsertData = new StaticSynInsertData();
        new Thread() {
            @Override
            public void run() {
                staticSynInsertData.insert();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                staticSynInsertData.insert1();
            }
        }.start();
    }
}

class StaticSynInsertData {
    public synchronized void insert() {
        System.out.println("执行insert");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行insert完毕");
    }

    public synchronized static void insert1() {
        System.out.println("执行insert1");
        System.out.println("执行inser1完毕");
    }
}
