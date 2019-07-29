package com.example.demo;

import java.util.Optional;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-22 14:50
 **/
public class JAVA8API {
	public static void main(String[] args) {
		User john = new User("jhn", 12);
		User dick = new User("jhn", 12);
		System.out.println(john==dick);
		System.out.println(john.equals(dick));
		//testOf();

		//testNullable();
	}

	private static void testNullable() {
		User user = null;
		User john = new User("jhn", 18);
		User dick = new User("dick", 12);
		System.out.println(Optional.ofNullable(user).orElse(john));
		System.out.println(Optional.ofNullable(john).get());
		System.out.println(Optional.ofNullable(dick).orElse(john));
		System.out.println(Optional.ofNullable(user).orElseGet(() -> john));
		System.out.println();
	}

	private static void testOf() {
		try {

			User user1 = new User();
			Optional<User> userOptional1 = Optional.of(user1);
			if (userOptional1.isPresent()) {
				System.out.println("user1 is not null");
			}
			User user2 = null;
			//NullPointerException
			Optional userOptional2 = Optional.of(user2);

			if (userOptional2.isPresent()) {
				System.out.println("user2 is not null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	static class User {
		private String name;
		private Integer age;

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

		public User(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public User() {
		}
	}
}