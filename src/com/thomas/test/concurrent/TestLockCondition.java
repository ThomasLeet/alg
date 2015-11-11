package com.thomas.test.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.condition相当于Object 监视器方法（wait、notify 和 notifyAll）<br>
 *   分解成截然不同的对象，以便通过将这些对象与任意 Lock 实现组合使用<br>
 * 2.所有condition操作都要在持有锁的情况下，就是说在lock() unlock()之间<br>
 * 3.在等待 Condition 时，允许发生“虚假唤醒”，这通常作为对基础平台语义的让步。<br>
 *   对于大多数应用程序，这带来的实际影响很小，因为 Condition 应该总是在一个循环中被等待<br>
 *   ，并测试正被等待的状态声明。某个实现可以随意移除可能的虚假唤醒，<br>
 *   但建议应用程序程序员总是假定这些虚假唤醒可能发生，因此总是在一个循环中等待。<br>
 * @author thomas
 *
 */
public class TestLockCondition {

	public static int[] queue;
	public static int cursor;
	public static int CAPACITY = 10;
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition putCondition = lock.newCondition();
	public static Condition getCondition = lock.newCondition();
	private static int TOTAL = 20;

	static {
		queue = new int[10];
		cursor = 0;
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i <= TOTAL; i++) {
			Thread t = new Thread(new Producter(i));
			t.start();
		}
		Customer c = new Customer();
		for (int i = 0; i <= TOTAL; i++) {
			System.out.println("queue length : "+cursor+" , "+c.get());
		}
	}

	public static class Producter implements Runnable {

		private int data;

		public Producter(int data) {
			this.data = data;
		}

		@Override
		public void run() {
			lock.lock();
			try {
				/**
				 * 在等待 Condition 时，允许发生“虚假唤醒”，这通常作为对基础平台语义的让步。
				 * 对于大多数应用程序，这带来的实际影响很小，因为 Condition 应该总是在一个循环中被等待
				 * ，并测试正被等待的状态声明。某个实现可以随意移除可能的虚假唤醒，
				 * 但建议应用程序程序员总是假定这些虚假唤醒可能发生，因此总是在一个循环中等待。
				 */
				while (cursor >= CAPACITY) {
					putCondition.await();
				}
				queue[cursor++] = data;
				getCondition.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}

	public static class Customer {
		public int get() throws InterruptedException {
			lock.lock();
			try {
				while (cursor <= 0) {
					getCondition.await();
				}
				int data = queue[--cursor];
				queue[cursor] = -1;
				putCondition.signalAll();
				return data;
			}finally{
				lock.unlock();
			}
		}
	}

}
