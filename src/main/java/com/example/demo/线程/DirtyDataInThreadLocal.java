package com.example.demo.线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-23 15:34
 **/
public class DirtyDataInThreadLocal {
	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public static void main(String[] args){
		ExecutorService pool = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 2; i++) {
			Mythread mythread = new Mythread();
			pool.execute(mythread);
		}

	}

	private static class Mythread extends Thread{
		private static boolean flag = true;

		@Override
		public void run() {
			if (flag){
				threadLocal.set(this.getName() + ", session info.");
				flag  = false;
			}
			System.out.println(this.getName()+ " 线程是 " + threadLocal.get());
			threadLocal.remove();
			flag  = true;
		}
	}
}
