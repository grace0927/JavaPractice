/**
 * 
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/add-two-numbers/
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two 
 * numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 */
public class AddTwoNumbers {
	/*
	 * don't work for large int
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int one = 0;
		int two = 0;
		int index = 0;
		
		while(l1 != null) {
			one += l1.val*Math.pow(10,index);
			l1 = l1.next;
			index++;
		}
		
		index = 0;
		while(l2 != null) {
			two += l2.val*Math.pow(10,index);
			System.out.println(two);
			l2 = l2.next;
			index++;
		}
		
		int total = one+two;
		ListNode result = null;
		ListNode itor = null;
		if(total == 0) {
		    return new ListNode(0);
		}
		while(total>0) {
			int cur = total%10;
			ListNode temp = new ListNode(cur);
			if(itor != null) {
			    itor.next = temp;
			} else {
				result = temp;
			}
			itor = temp;
			total = (int)total/10;
		}
		
		return result;
    }
	
	/*
	 * using queue
	 */
	public ListNode addTwoNumbersAlter(ListNode l1, ListNode l2) {
		Queue<Integer> one = new LinkedList<>();
		Queue<Integer> two = new LinkedList<>();
		Queue<Integer> queue = new LinkedList<>();
		
		while(l1 != null) {
			one.add(l1.val);
			l1 = l1.next;
		}
		
		while(l2 != null) {
			two.add(l2.val);
			l2 = l2.next;
		}
		
		boolean over = false;
		while(!(one.isEmpty() || two.isEmpty())) {
			int cur = one.poll() + two.poll();
			if(over) {
				cur++;
				over = false;
			}
			if(cur >= 10) {
				over = true;
				cur -= 10;
			}
			queue.add(cur);
		}
		while(!one.isEmpty()) {
			int cur = one.poll();
			if(over) {
				cur++;
				over = false;
			}
			if(cur >= 10) {
				over = true;
				cur -= 10;
			}
			queue.add(cur);
		}
		while(!two.isEmpty()) {
			int cur = two.poll();
			if(over) {
				cur++;
				over = false;
			}
			if(cur >= 10) {
				over = true;
				cur -= 10;
			}
			queue.add(cur);
		}
		if(over) {
			queue.add(1);
		}
		
		ListNode result = null;
		ListNode itor = null;
		while(!queue.isEmpty()) {
			ListNode temp = new ListNode(queue.poll());
			if(itor != null) {
				itor.next = temp;
			} else {
				result = temp;
			}
			itor = temp;
		}
		
		return result;
    }

}
