package com.example.demo.引用;

import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @description: 软引用
 * @author: Mr.Zhang
 * @create: 2019-07-22 09:08
 **/
public class SoftReferenceHouse {
	public static void main(String[] args) {
		//List<House> houses = new ArrayList<>();
		List<SoftReference> houses = new ArrayList<>();
		ThreadLocal<House> houseThreadLocal = new ThreadLocal<>();

		int i = 0;
		while (true) {
			//houses.add(new House());
			SoftReference<House> buyes2 = new SoftReference<>(new House());
			houses.add(buyes2);
			System.out.println("i=" + (++i));
		}

	}

}

class House extends AbstractApplicationContext {
	private static final Integer DOOR_NUMBER = 2000;
	public Door[] doores = new Door[DOOR_NUMBER];

	@Override
	protected void refreshBeanFactory() throws BeansException, IllegalStateException {

	}

	@Override
	protected void closeBeanFactory() {

	}

	@Override
	public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
		return null;
	}

	class Door {
	}
}