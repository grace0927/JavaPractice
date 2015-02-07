/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 */
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
			return head;
		} else if(head.next == null) {
			return head;
		} else {
			Stack<ListNode> stack = new Stack<>();
			stack.push(head);
			head = head.next;
			boolean dup = false;
			
			while(head != null) {
				if(head.val == stack.peek().val) {
					dup = true;
					head = head.next;
					continue;
				} else {
					if(dup) {
						stack.pop();
					}
					stack.push(head);
					head = head.next;
					dup = false;
				}
			}
			if(dup) {
				stack.pop();
			}
			if(stack.empty()) {
				return null;
			}
			ListNode result = stack.pop();
			result.next = null;
			while(!stack.empty()) {
				stack.peek().next= result;
				result = stack.pop();
			}
			return result;
		}
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII test = new RemoveDuplicatesFromSortedListII();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(2);
		one.next = two;
		two.next = three;
		System.out.println(test.deleteDuplicates(one));

	}

}
