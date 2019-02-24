package me.liumingbo.threads.countDownLatch_cyclicBarrier_semaphore;

import java.util.concurrent.Phaser;

/**
 * Phaser顾名思义，与阶段相关。
 * Phaser比较适合这样一种场景，一种任务可以分为多个阶段，现希望多个线程去处理该批任务，对于每个阶段，多个线程可以并发进行，但是希望保证只有前面一个阶段的任务完成之后才能开始后面的任务。
 * 这种场景可以使用多个CyclicBarrier来实现，每个CyclicBarrier负责等待一个阶段的任务全部完成。
 * 但是使用CyclicBarrier的缺点在于，需要明确知道总共有多少个阶段，同时并行的任务数需要提前预定义好，且无法动态修改。而Phaser可同时解决这两个问题。
 *
 * Created by bjliumingbo on 2017/5/18.
 */
public class PhaserTest {

	public static void main(String[] args) {
		int parties = 3;
		int phases = 4;

		final Phaser phaser = new Phaser(parties) {
			@Override
			protected boolean onAdvance(int phase, int registeredParties) {
				System.out.println("====== Phase : " + phase + " ======");
				return registeredParties == 0;
			}
		};

		for (int i = 0; i < parties; i++) {
			int threadId = i;
			Thread thread = new Thread() {
				@Override
				public void run() {
					for (int phase = 0; phase < phases; phase++) {
						System.out.println(String.format("Thread %s, phase %s", threadId, phase));
						phaser.arriveAndAwaitAdvance();
					}
				}
			};
			thread.start();
		}
	}

}
