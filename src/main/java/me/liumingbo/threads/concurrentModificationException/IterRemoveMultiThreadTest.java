package me.liumingbo.threads.concurrentModificationException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 虽然Vector的方法采用了synchronized进行了同步，但是由于Vector是继承的AbstarctList，因此通过Iterator来访问容器的话，事实上是不需要获取锁就可以访问。
 * 那么显然，由于使用iterator对容器进行访问不需要获取锁，在多线程中就会造成当一个线程删除了元素，由于modCount是AbstarctList的成员变量，因此可能会导致在其他线程中modCount和expectedModCount值不等。
 *
 * Created by FirenzesEagle on 2016/12/13.
 * Email:liumingbo2008@gmail.com
 */
public class IterRemoveMultiThreadTest {
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            arrayList.add(i);
        }
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                Iterator<Integer> iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    System.out.println(integer);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        };
        Thread thread2 = new Thread() {
            public void run() {
                Iterator<Integer> iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    Integer integer = iterator.next();
                    if (integer == 2){
                        iterator.remove();
                    }
                }
            };
        };
        thread1.start();
        thread2.start();
    }

    ;
}
