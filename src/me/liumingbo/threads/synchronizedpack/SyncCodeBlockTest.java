package me.liumingbo.threads.synchronizedpack;

import java.util.ArrayList;

/**
 * synObject可以是this，代表获取当前对象的锁，也可以是类中的一个属性，代表获取该属性的锁。
 *
 * Created by FirenzesEagle on 2016/12/9.
 * Email:liumingbo2008@gmail.com
 */
public class SyncCodeBlockTest {
    public static void main(String[] args) {
        final SyncCodeBlockThisInsertData synCodeBlockThisInsertData = new SyncCodeBlockThisInsertData();

        new Thread() {
            public void run() {
                synCodeBlockThisInsertData.insert(Thread.currentThread());
            }
        }.start();

        new Thread() {
            public void run() {
                synCodeBlockThisInsertData.insert(Thread.currentThread());
            }
        }.start();
    }
}

class SyncCodeBlockThisInsertData {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public void insert(Thread thread) {
        synchronized (this){
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName() + "在插入数据" + i);
                arrayList.add(i);
            }
        }
    }
}

class SyncCodeBlockAttributeInsertData {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Object object = new Object();

    public void insert(Thread thread) {
        synchronized (object){
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName() + "在插入数据" + i);
                arrayList.add(i);
            }
        }
    }
}