package com.example.demo.锁;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @program: demo
 * @description: 按序打印
 * @author: Mr.Zhang
 * @create: 2019-07-17 17:01
 **/
public class ZeroEvenOdd {
	private Lock lock = new ReentrantLock();
	private int n;
	private Condition zero, even, odd;
	private volatile int flag = 0;

	public ZeroEvenOdd(int n) {
		this.n = n;
		zero = lock.newCondition();
		even = lock.newCondition();
		odd = lock.newCondition();
	}

	public static void main(String[] args) {
		ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(9);
		new Thread(() -> {
			try {
				zeroEvenOdd.zero(x -> System.out.print(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				zeroEvenOdd.even(x -> System.out.print(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				zeroEvenOdd.odd(x -> System.out.print(x));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public void zero(IntConsumer printNumber) throws InterruptedException {
		try {

			lock.lock();
			for (int i = 1; i <= n; i++) {
				while (flag != 0) {
					zero.await();
				}
				printNumber.accept(0);
				if ((i & 1) == 0) {
					flag = 2;
					even.signalAll();
				} else {
					flag = 1;
					odd.signalAll();
				}

			}
		} finally {
			lock.unlock();
		}


	}

	public void even(IntConsumer printNumber) throws InterruptedException {
		try {
			lock.lock();
			for (int i = 2; i <= n; i += 2) {
				while (flag != 2) {
					even.await();
				}
				printNumber.accept(i);
				flag = 0;
				zero.signalAll();
			}
		} finally {
			lock.unlock();
		}


	}

	public void odd(IntConsumer printNumber) throws InterruptedException {
		try {
			lock.lock();
			for (int i = 1; i <= n; i += 2) {
				while (flag != 1) {
					odd.await();
				}
				printNumber.accept(i);
				flag = 0;
				zero.signalAll();
			}
		} finally {
			lock.unlock();
		}

	}
}
