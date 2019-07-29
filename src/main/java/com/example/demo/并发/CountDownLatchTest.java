package com.example.demo.并发;

import java.util.concurrent.CountDownLatch;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-16 10:03
 **/
public class CountDownLatchTest {

	public static void main(String[] args) {
		recursion(4);
	}

	private static void recursion(int num) {
		if (num > 2) {
			recursion(num - 1);
		}
		System.out.println(num);
	}
}
