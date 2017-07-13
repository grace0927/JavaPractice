/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 *
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode fast=head, slow=head;
		while (fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast==slow) {
				return true;
			}
		}

		return false;
	}
}
