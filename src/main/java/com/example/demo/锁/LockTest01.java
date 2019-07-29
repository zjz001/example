package com.example.demo.锁;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: 锁锁
 * @author: Mr.Zhang
 * @create: 2019-07-17 14:46
 **/
public class LockTest01 {
	public static void main(String[] args) {
		new Thread(() -> {
			Count count = new Count();
			count.print();
		}).start();
		new Thread(() -> {
			Count count = new Count();
			count.print();
		}).start();

	}

	//可重入锁
	synchronized void method1() throws Exception {
		Thread.sleep(1000);
		method2();
	}

	synchronized void method2() throws Exception {
		Thread.sleep(1000);
	}
	//
}

/**
 * 不可重入锁
 */
class NLock {
	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}

class Count {
	NLock lock = new NLock();

	public void print() {
		try {
			lock.lock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doAdd();
		lock.unlock();
	}

	public void doAdd() {
		try {
			lock.lock();
			ReentrantLock reentrantLock = new ReentrantLock();
			reentrantLock.lockInterruptibly();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//do something
		lock.unlock();
	}
}
