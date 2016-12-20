package me.liumingbo.threads.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列使用最经典的场景就是socket客户端数据的读取和解析，读取数据的线程不断将数据放入队列，
 * 然后解析线程不断从队列取数据解析。还有其他类似的场景，只要符合生产者-消费者模型的都可以使用阻塞队列。
 *
 * Created by FirenzesEagle on 2016/12/20.
 * Email:liumingbo2008@gmail.com
 */
public class ProducerConsumerBlockingQueueTest {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

    public static void main(String[] args) {
        ProducerConsumerBlockingQueueTest producerConsumerBlockingQueueTest = new ProducerConsumerBlockingQueueTest();
        Producer producer = producerConsumerBlockingQueueTest.new Producer();
        Consumer consumer = producerConsumerBlockingQueueTest.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    queue.take();
                    System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    queue.put(1);
                    System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
