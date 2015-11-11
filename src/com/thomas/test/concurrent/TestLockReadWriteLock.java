package com.thomas.test.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLockReadWriteLock {

	private static int TOTAL = 1000;
	private static CountDownLatch countDown = new CountDownLatch(TOTAL);

	public static void main(String[] args) throws InterruptedException {
		TestNumber num = new TestNumber();
		long start = System.currentTimeMillis();
		for (int i = 0; i < TOTAL; i++) {
			Thread t = new Thread(new TestWriteThread(num));
			t.start();
			System.out.print(num);
		}
		countDown.await();
		System.out.print(num + " , spend time :"
				+ (System.currentTimeMillis() - start));
	}

	public static class TestWriteThread implements Runnable {
		TestNumber num;

		public TestWriteThread(TestNumber num) {
			this.num = num;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				num.setNumber();
			}
			countDown.countDown();
		}
	}

	public static class TestNumber {
		public int number;
		public int doubleNumber;

		public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		public static Lock r = lock.readLock();
		public static Lock w = lock.writeLock();

		public int getNumber() {
			return number;
		}

		public void setNumber() {
			w.lock();
			this.number = number + 1;
			try {
				// Random rand = new Random();
				// Thread.sleep(rand.nextInt(100));
				this.doubleNumber = this.number * 2;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				w.unlock();
			}

		}

		public int getDoubleNumber() {
			return doubleNumber;
		}

		@Override
		public String toString() {
			String str = null;
			r.lock();
			try {
				if (number * 2 != doubleNumber) {
					str = "number : " + number + " , double : " + doubleNumber
							+ " , right : " + number * 2;
				} else {
					str = "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				r.unlock();
			}

			return str;
		}

	}
}
