package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * https://oj.leetcode.com/problems/reorder-list/
 *  
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
 * reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 */

public class ReorderList {
	public void reorderList(ListNode head) {
        /* empty and single Node exception */
		if(head!=null && head.next!=null) {
            Queue<ListNode> left = new LinkedList<>();
            Stack<ListNode> right = new Stack<>();
            
            ListNode templeft = head;
            ListNode tempright = head;
            
            while(templeft!=null && tempright!=null && tempright.next!=null) {
            	templeft = templeft.next;
            	tempright = tempright.next.next;
            }
            
            tempright = templeft;
            templeft = head;
            while(templeft!=null && tempright!=null){
            	left.add(templeft);
            	right.push(tempright);
            	templeft = templeft.next;
            	tempright = tempright.next;
            }
            if(tempright!=null) {
            	right.push(tempright);
            }
            
            /* begin reordering */
            ListNode result = head;
            left.remove(); // poll out head
            while(!right.empty()){
            	result.next = right.pop();
            	result = result.next;
            	if(!left.isEmpty()) {
            		result.next = left.remove();
            		result = result.next;
            		System.out.println("set left " + result.val);
            	} else {
            		System.out.println("set null");
            		result.next = null;
            		result = result.next;
            	}
            }
        }
    }
	
	public static void main(String[] argv){
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		ReorderList test = new ReorderList();
		
		test.reorderList(one);
		
		ListNode temp = one;
		
		while(temp!=null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}
