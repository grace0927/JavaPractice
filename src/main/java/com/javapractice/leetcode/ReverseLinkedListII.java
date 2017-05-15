/**
 *
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author Jianyu Feng
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
 *
 */
public class ReverseLinkedListII {
	public ListNode reverseBetweenStack(ListNode head, int m, int n) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode top = new ListNode(-1);
		top.next = head;

		ListNode cur = top;
		for(int i=0; i<m-1; i++) {
			cur = cur.next;
		}

		ListNode start = cur;
		cur = cur.next;
		Stack<ListNode> stack = new Stack<>();
		for(int i=m-1; i<n; i++) {
			if(stack.empty()) {
				stack.push(cur);
				cur = cur.next;
			} else {
				ListNode temp = cur;
				cur = cur.next;
				temp.next = stack.peek();
				stack.push(temp);
			}
		}

		ListNode end = cur;
		ListNode last = stack.pop();
		start.next = last;
		while(!stack.empty()) {
			last = stack.pop();
		}
		last.next = end;
		return top.next;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy=new ListNode(0), prev=dummy, slow=dummy, fast=dummy;
		dummy.next = head;

		for (int i=0; i<m; i++) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}

		ListNode tmp = null;
		for (int i=m; i<=n; i++) {
			ListNode next = fast.next;
			fast.next = tmp;
			tmp = fast;
			fast = next;
		}

		prev.next = tmp;
		slow.next = fast;

		return dummy.next;
	}
}
