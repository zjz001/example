package com.example.demo.锁;

/**
 * @program: demo
 * @description: 锁
 * @author: Mr.Zhang
 * @create: 2019-07-17 13:48
 **/
class Deadlock {
	public static String str1 = new String("str1");
	public static String str2 = new String("str1");
	public static void main(String[] args) {
		Thread thread1 = new Thread(() -> {
			try {
				while (true) {
					synchronized (Deadlock.str1) {
						System.out.println(Deadlock.str1.hashCode());
						System.out.println(Deadlock.str1.equals(str2));
						System.out.println(Thread.currentThread().getName() + "锁住 str1");
						Thread.sleep(1000);
						synchronized (Deadlock.str2) {
							System.out.println(Deadlock.str2.hashCode());
							System.out.println(Thread.currentThread().getName() + "锁住 str2");
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		Thread thread2 = new Thread(() -> {
			try {
				while (true) {
					synchronized (Deadlock.str2) {
						System.out.println(Deadlock.str2.hashCode());
						System.out.println(Thread.currentThread().getName() + "锁住 str2");
						Thread.sleep(1000);
						synchronized (Deadlock.str1) {
							System.out.println(Thread.currentThread().getName() + "锁住 str1");
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		thread1.start();
		thread2.start();
	}
}