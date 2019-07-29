package com.example.demo.锁;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: demo
 * @description: 可中断锁
 * @author: Mr.Zhang
 * @create: 2019-07-17 15:28
 **/
public class ReentrantLockTest {
	public static void main(String[] args) throws InterruptedException {
		final Lock lock = new ReentrantLock(true);
		for (int i = 0; i < 5; i++) {
			//lock.lock();
			int finalI = i;
			new Thread(() -> {
				System.out.println("开始"+finalI);
				boolean b = lock.tryLock();//注释这行把下面注释打开再试试
				System.out.println(b);
			/*try {
				lock.lockInterruptibly();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
				System.out.println(Thread.currentThread().getName() + " interrupted." + finalI);
				lock.unlock();
			}).start();

		}
		Thread t2 = new Thread(() -> {
			boolean b = lock.tryLock();//注释这行把下面注释打开再试试
			System.out.println(b);
			System.out.println(Thread.currentThread().getName() + " interrupted222222.");
		});
		t2.start();
		Thread.sleep(3000);
	}
}
