package com.thomas.test.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockCyclicBarrier {

	public static int count = 0;
	public static ReentrantLock lock = new ReentrantLock();
	private static int TOTAL = 1000;
	private static CyclicBarrier barrier = new CyclicBarrier(TOTAL);

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		for (int i = 0; i < TOTAL; i++) {
			Thread t = new Thread(new TestThread(lock, barrier));
			t.start();
		}
		System.out.println(count);
	}

	public static class TestThread implements Runnable {
		ReentrantLock lock;

		public TestThread(ReentrantLock lock, CyclicBarrier barrier) {
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(100));
			} catch (Exception e) {
				e.printStackTrace();
			}
			lock.lock();
			System.out.println(lock.getHoldCount());
			TestLockCyclicBarrier.count = TestLockCyclicBarrier.count + 1;
			lock.unlock();
		}
	}
}
