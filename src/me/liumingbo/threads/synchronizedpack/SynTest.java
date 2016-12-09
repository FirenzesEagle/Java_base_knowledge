package me.liumingbo.threads.synchronizedpack;

import java.util.ArrayList;

/**
 * Created by FirenzesEagle on 2016/12/9.
 * Email:liumingbo2008@gmail.com
 */
public class SynTest {
    public static void main(String[] args) {
        final SynInsertData synInsertData = new SynInsertData();

        new Thread() {
            public void run() {
                synInsertData.insert(Thread.currentThread());
            }
        }.start();

        new Thread() {
            public void run() {
                synInsertData.insert(Thread.currentThread());
            }
        }.start();
    }
}

class SynInsertData {
        private ArrayList<Integer> arrayList = new ArrayList<>();

        public synchronized void insert(Thread thread) {
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName() + "在插入数据" + i);
                arrayList.add(i);
            }
        }
}
