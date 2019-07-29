package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void arrayList() {
		List<Integer> arrayList = new ArrayList<>(10);

		arrayList.toArray();
		for (int i = 0; i < 1000000; i++) {
			arrayList.add(i);
		}
		long start = System.nanoTime();
		System.out.println(arrayList.get(20000));
		System.out.println("arrayList execution time:::" + (System.nanoTime()-start));
	}

	@Test
	public void linkedList() {
		List<Integer> linkedList = new LinkedList<Integer>();
		HashSet<Object> hashSet = new HashSet<>(16);
		TreeSet<Object> treeSet = new TreeSet<>();
		HashMap<Object, Object> hashMap = new HashMap<>(16);
		Map<Object, Object> concurrentHashMap = new ConcurrentHashMap<>(16);
		ConcurrentSkipListMap<Object, Object> concurrentSkipListMap = new ConcurrentSkipListMap<>();

		List<String> asList = Arrays.asList("1", "2", "3");
		for (int i = 0; i < 1000000; i++) {

			linkedList.add(i);
			linkedList.toArray();
		}
		long start = System.nanoTime();
		System.out.println(linkedList.get(20000));
		System.out.println("linkedList execution time:::" + (System.nanoTime()-start));
	}

	@Test
	public  void test02(){
	/*	CopyOnWriteArrayList<Integer> cow = new CopyOnWriteArrayList<>();
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			cow.add(i);
		}
		System.out.println("cowList execution time:::" + (System.nanoTime()-start));

		List<Integer> arrayList = new ArrayList<>();
		long start2 = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			arrayList.add(i);
		}
		System.out.println("arrayList execution time:::" + (System.nanoTime()-start2));


		List<Integer> arrayList2 = new ArrayList<>();
		long start3 = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			arrayList2.add(i);
		}
		CopyOnWriteArrayList<Integer> cow3 = new CopyOnWriteArrayList<>(arrayList2);


		System.out.println("arrayList3 execution time:::" + (System.nanoTime()-start3));*/


		Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		long start4 = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			concurrentHashMap.put("demo"+i, "test");
		}
		System.out.println("concurrentHashMap execution time:::" + (System.nanoTime()-start4)+"纳秒");

		Map<String, String> hashMap = new HashMap<>();
		long start5 = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			hashMap.put("demo"+i, "test");
		}
		System.out.println("hashMap execution time:::" + (System.nanoTime()-start5)+"纳秒");

	}

	/**
	 * 测试map默认大小
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Map<String, String> map = new HashMap<>(0);
		//map.put("hahaha", "hollischuang");

		Class<?> mapType = map.getClass();
		Method capacity = mapType.getDeclaredMethod("capacity");
		capacity.setAccessible(true);
		System.out.println("capacity : " + capacity.invoke(map));
	}
}