package com.example.demo.spring基础;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-26 10:58
 **/
public class ConditionalTest implements Condition {

	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		ClassLoader classLoader = context.getClassLoader();
		Environment environment = context.getEnvironment();
		BeanDefinitionRegistry registry = context.getRegistry();
		String property = environment.getProperty("os.name");


		return false;
	}

	public static void main(String[] args){
		Student student = new Student();

	}
}
class Student{
	private String name;
	private Integer age;

	public Student() {
		new Teacher();
	}

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}

class Teacher{
	private String name;
	private Integer age;

	public Teacher() {
		new Student();
	}

	public Teacher(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}