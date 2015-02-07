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
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = null;
		three.next = four;
		four.next = five;
		five.next = two;
		
		DetectCycle test = new DetectCycle();
		
		ListNode res = test.detectCycle(one);
		
		if(res!=null) {
			System.out.println(res.val);
		} else {
			System.out.println("no cycle detected");
		}
	}

}
