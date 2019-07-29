package com.example.demo.两数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: demo
 * @description: 两数之和
 * @author: Mr.Zhang
 * @create: 2019-07-16 15:46
 **/
public class TwoSum {
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		/*int[] ints = {2, 3, 4, 5};
		int[] ints1 = O1TwoSum(ints, 8);
		for (int i = 0; i < ints1.length; i++) {
			System.out.println(ints1[i]);

		}*/
		ListNode l1 = new ListNode(21);
		ListNode l2 = new ListNode(35);
		ListNode listNode = addTwoNumbers(l1, l2);
		System.out.println(listNode.toString());

	}

	public static int[] O1TwoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}


	//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
	//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}


	public static int[] stackSum(int[] nums, int target) {
		//将全部结果入栈
		for (int num : nums) {
			stack.push(num);
		}
		int num1 = 0;
		int num2 = 0;
		while (!stack.isEmpty()) {
			num1 = stack.pop();
			num2 = stack.peek();
			int ret = num1 + num2;
			if (ret == target) {
				break;
			}
		}
		int index1 = 0, index2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (num1 == nums[i] && index1 == 0) {
				index1 = i;
			}
			if (num2 == nums[i] && index2 == 0) {
				index2 = i;
			}
		}
		return new int[]{index1, index2};
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode{" +
					"val=" + val +
					", next=" + next +
					'}';
		}
	}
}
