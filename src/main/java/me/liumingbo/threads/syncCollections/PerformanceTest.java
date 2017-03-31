package me.liumingbo.threads.syncCollections;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 同步容器的性能问题
 * Vector的性能比ArrayList数据多的时候要好，单线程的话，上锁解锁的时间可以忽略，
 * 但是，arraylist和vector都是可变数组，当容量不够的时候，arraylist是增加自身的一半，而vector是增加一倍，从这里看vector要省很多时间在增加容量上。也许这就是优势所在。
 *
 * Created by FirenzesEagle on 2016/12/13.
 * Email:liumingbo2008@gmail.com
 */
public class PerformanceTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行100000次插入操作耗时：" + (end - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            vector.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("Vector进行100000次插入操作耗时：" + (end - start) + "ms");
    }
}
