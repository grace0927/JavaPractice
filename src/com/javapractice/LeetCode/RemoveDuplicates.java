package com.javapractice.LeetCode;

/*
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once..
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 */

public class RemoveDuplicates {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		} else if(head.next == null) {
			return head;
		} else {
			ListNode pointer = head;
			while(pointer != null  && pointer.next != null) {
				if(pointer.next.val == pointer.val) {
					pointer.next = pointer.next.next;
					continue;
				} else {
					pointer = pointer.next;
				}
			}
		}
        return head;
    }
}
