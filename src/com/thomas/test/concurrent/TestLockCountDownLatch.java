package com.thomas.test.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockCountDownLatch {

	public static int count = 0;
	public static ReentrantLock lock = new ReentrantLock();
	private static int TOTAL = 1000;
	private static CountDownLatch countDown = new CountDownLatch(TOTAL);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < TOTAL; i++) {
			Thread t = new Thread(new TestThread(lock, countDown));
			t.start();
		}
		countDown.await();
		System.out.println("count : "+count);
	}

	public static class TestThread implements Runnable {
		ReentrantLock lock;

		public TestThread(ReentrantLock lock, CountDownLatch countDown) {
			this.lock = lock;
		}

		@Override
		public void run() {
			try {
				Random rand = new Random();
				Thread.sleep(rand.nextInt(100));
				//超时后直接返回，也可以while知道获得锁
				if(!lock.tryLock(1,TimeUnit.MILLISECONDS) ){
					countDown.countDown();
					return;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				TestLockCountDownLatch.count = TestLockCountDownLatch.count + 1;
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
			countDown.countDown();
		}
	}
}
