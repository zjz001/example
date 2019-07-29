package com.example.demo.锁;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-18 09:52
 **/
public class CyclicBarrierTest {

	private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
			.setNameFormat("demo-pool-%d").build();
	static final ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 2,
			2L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory);
	static CyclicBarrier cyclicBarrier = new CyclicBarrier(Runtime.getRuntime().availableProcessors(), () -> {
		executor.execute(() -> {
		});
	});
	private static CountDownLatch countDownLatch = new CountDownLatch(2);

	public static void main(String[] args) {
		//CompletableFuture<List> pOrderFuture = CompletableFuture.supplyAsync(this::getPOrders);
		//CompletableFuture<List> dOrderFuture = CompletableFuture.supplyAsync(this::getDOrders);
		//pOrderFuture.thenCombine(dOrderFuture, this::check).thenAccept(this::save);
		System.out.println(11111);
		test01();
		System.out.println(22222);

	}

	private static void test01() {
		executor.execute(() -> {
			System.out.println(Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(1L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			countDownLatch.countDown();
		});
		executor.execute(() -> {
			System.out.println(Thread.currentThread().getName());
			countDownLatch.countDown();
		});
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("33333");
	}

	private static void test02() {
		executor.execute(() -> {
			System.out.println(Thread.currentThread().getName());
			countDownLatch.countDown();
		});
	}

}
