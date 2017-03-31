package me.liumingbo.threads.concurrentModificationException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by FirenzesEagle on 2016/12/13.
 * Email:liumingbo2008@gmail.com
 */
public class IterRemoveSingleThreadTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                iterator.remove();
            }
        }
    }
}
