/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://oj.leetcode.com/problems/rotate-list/
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 */
public class RotateList {
	public ListNode rotateRightOld(ListNode head, int n) {
		if(head == null) {
			return head;
		}

		ListNode fast = head;
		for(int i=0; i<=n; i++) {
			fast = fast.next;
			if(fast == null) {
				fast = head;
			}
		}

		ListNode slow = head;
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
			if(slow == null) {
				slow = head;
			}
		}
		if(slow.next == null) {
			return head;
		}

		fast = slow.next;
		slow.next = null;
		slow = fast;
		while(fast.next != null) {
			fast = fast.next;
		}
		fast.next = head;

		return slow;
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head==null) {
			return head;
		}

		k %= getLength(head);
		ListNode fast=head, slow=head;
		while (k>0) {
			fast = fast.next;
			k--;
		}

		while (fast!=null && fast.next!=null) {
			fast = fast.next;
			slow = slow.next;
		}

		fast.next = head;
		head = slow.next;
		slow.next = null;

		return head;
	}

	private int getLength(ListNode head) {
		int len=0;
		while (head!=null) {
			len++;
			head = head.next;
		}
		return len;
	}
}
