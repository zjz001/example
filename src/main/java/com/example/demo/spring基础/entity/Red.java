package com.example.demo.spring基础.entity;

import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-26 16:54
 **/
@Component
public class Red {
	private String name;

	public Red() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
