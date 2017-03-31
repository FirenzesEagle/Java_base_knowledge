package me.liumingbo.threads.concurrentModificationException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 调用list.remove()方法导致modCount和expectedModCount的值不一致。
 * 注意，像使用for-each进行迭代实际上也会出现这种问题。
 *
 * Created by FirenzesEagle on 2016/12/13.
 * Email:liumingbo2008@gmail.com
 */
public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                arrayList.remove(integer);
            }
        }
    }
}
