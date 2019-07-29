package com.example.demo.锁;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-17 16:51
 **/
public class FooBar {
	private int n;
	private volatile static int flag = 1;
	private static Lock lock = new ReentrantLock();
	private static Condition foo = lock.newCondition();
	private static Condition bar = lock.newCondition();

	public static void main(String[] args) {
		FooBar fooBar = new FooBar(5);

	}

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {
		try {
			lock.lock();
			for (int i = 0; i < n; i++) {
				while (flag != 1) {
					foo.await();
				}
				// printFoo.run() outputs "foo". Do not change or remove this line.
				printFoo.run();
				flag = 2;
				bar.signalAll();
			}
		} finally {
			lock.unlock();
		}

	}

	public void bar(Runnable printBar) throws InterruptedException {
		try {
			lock.lock();
			for (int i = 0; i < n; i++) {
				while (flag != 2) {
					bar.await();
				}
				// printBar.run() outputs "bar". Do not change or remove this line.
				printBar.run();
				flag = 1;
				foo.signalAll();

			}
		} finally {
			lock.unlock();
		}

	}
}
