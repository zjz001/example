package com.example.demo.排序;

import java.util.Arrays;

/**
 * @program: demo
 * @description: 冒泡排序
 * @author: Mr.Zhang
 * @create: 2019-07-29 08:57
 **/
public class BubbleSort {
	public static int[] sort(int[] arr) {
		// 交换标志
		boolean bChange = false;

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					bChange = true;
				}
			}
			// 如果标志为false，说明本轮遍历没有交换，已经是有序数列，可以结束排序
			if (!bChange) {
				break;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		//int[] arr = {2, 7, 6, 40, 5, 1, 9};
		int[] arr = {2, 3, 4, 4, 5, 6, 1};
		int[] sort = sort(arr);
		System.out.println(Arrays.toString(sort));
	}
}
