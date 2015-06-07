package com.javapractice.leetcode;

/*
 * https://oj.leetcode.com/problems/linked-list-cycle/
 * 
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */

public class DetectCycle {

	public ListNode detectCycle(ListNode head) {
        if(head!=null) {
        	ListNode slow = head;
        	ListNode fast = head;
        	
        	do {
        		slow = slow.next;
        		if(fast!=null && fast.next!=null) {
        			fast = fast.next.next;
        		} else {
        			return null;
        		}
        	} while (slow!=fast);
        	
        	slow = head;
        	
        	while(slow!=fast) {
        		slow = slow.next;
        		fast = fast.next;
        	}
        	
        	return fast;
        }
		return null;
    }
}
