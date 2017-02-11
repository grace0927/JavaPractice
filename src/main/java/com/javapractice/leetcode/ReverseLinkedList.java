/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author jianyu
 * https://leetcode.com/problems/reverse-linked-list/
 * Reverse a singly linked list.
 *
 */
public class ReverseLinkedList {
    public ListNode reverseListStack(ListNode head) {
        if(head==null || head.next==null) {
			return head;
		}
		Stack<ListNode> stack = new Stack<>();
		while(head!=null) {
			stack.push(head);
			head = head.next;
		}
		head = stack.pop();
		ListNode pnt = head;
		while(!stack.isEmpty()) {
			pnt.next = stack.peek();
			pnt = stack.pop();
		}
		pnt.next = null;
		return head;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
			return head;
		}
		
		ListNode last = head;
		head = head.next;
		last.next = null;
		while(head.next != null) {
			ListNode pnt = head.next;
			head.next = last;
			last = head;
			head = pnt;
		}
		head.next = last;
		
		return head;
    }
    
    public ListNode reverseListRec(ListNode head) {
        if(head==null || head.next==null) {
			return head;
		}
		
		ListNode pnt = head.next;
		head.next = null;
		ListNode res = reverseList(pnt);
		pnt.next = head;
		
		return res;
    }
}
