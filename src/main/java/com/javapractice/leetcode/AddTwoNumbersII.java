/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/add-two-numbers-ii/
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 */
public class AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = buildStack(l1);
		Stack<Integer> s2 = buildStack(l2);
		ListNode dummy = new ListNode(1);
		int carryover = 0;

		while(!s1.isEmpty() || !s2.isEmpty()) {
			carryover += (s1.isEmpty()) ? 0 : s1.pop();
			carryover += (s2.isEmpty()) ? 0 : s2.pop();
			ListNode node = new ListNode(carryover%10);
			insert(dummy, node);
			carryover /= 10;
		}

		return carryover==0 ? dummy.next : dummy;
	}

	public void insert(ListNode prev, ListNode node) {
		ListNode next = prev.next;
		prev.next = node;
		node.next = next;
	}

	public Stack<Integer> buildStack(ListNode node) {
		Stack<Integer> stack = new Stack<>();

		while(node!=null) {
			stack.push(node.val);
			node = node.next;
		}

		return stack;
	}
}
