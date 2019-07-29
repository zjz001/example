package com.example.demo;

import com.example.demo.spring基础.MyFactoryBean;
import com.example.demo.spring基础.MyImportBeanDefinitionRegistrar;
import com.example.demo.spring基础.entity.Blue;
import com.example.demo.spring基础.entity.Green;
import com.example.demo.spring基础.entity.Red;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-26 16:56
 **/
@Configuration
@Import({MyImportBeanDefinitionRegistrar.class})
public class IOCTest {

/*	@Bean
	public Red red(){
		return new Red();
	}*/
	/*@Bean
	public Blue blue(){
		return new Blue();
	}*/

	@Bean
	public MyFactoryBean myFactoryBean(){
		return new MyFactoryBean();
	}

	@Test
	public void testImportBean(){
		printBean();


	}

	@Test
	public void printBean(){
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IOCTest.class);
		//String applicationName = applicationContext.getApplicationName();
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		for (String beanNamesForType : beanDefinitionNames) {
			System.out.println("beanName:::"+beanNamesForType);
		}
		Object myFactoryBean = applicationContext.getBean("myFactoryBean");
		Object myFactoryBean1 = applicationContext.getBean("myFactoryBean");
		System.out.println("bean类型:::"+myFactoryBean.getClass());
	}
	@Test
	public void test01(){
		List<String> asList = Arrays.asList("2", "3", "6");
		ArrayList<Green> arrayList = new ArrayList<>();
		Green green;
		for (int i = 0; i < asList.size(); i++) {
			green = new Green();
			green.setName("nihao"+i);
			System.out.println(green.hashCode());
			arrayList.add(green);
		}
		for (Green green1 : arrayList) {
			System.out.println(green1);
		}
	}
}
