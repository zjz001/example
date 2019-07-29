package com.example.demo.spring基础;

import com.example.demo.spring基础.entity.Red;
import org.springframework.beans.factory.FactoryBean;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-26 18:26
 **/
public class MyFactoryBean implements FactoryBean<Red> {
	@Override
	public Red getObject() throws Exception {
		System.out.println("----------------getObject");
		return new Red();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
