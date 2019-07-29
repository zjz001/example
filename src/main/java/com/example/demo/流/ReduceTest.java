package com.example.demo.流;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @program: demo
 * @description:
 * @author: Mr.Zhang
 * @create: 2019-07-26 09:49
 **/
public class ReduceTest {
	public static void main(String[] args) {

		List<String> integers = Arrays.asList("2", "3");
		Optional<String> reduce = integers.stream().reduce((a, b) ->
				a + "," + b
		);
		System.out.println(reduce.get());
	}


}
