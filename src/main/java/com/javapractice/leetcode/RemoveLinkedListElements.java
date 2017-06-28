/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/remove-linked-list-elements/
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class RemoveLinkedListElements {
	public ListNode removeElementsOld(ListNode head, int val) {
		while(head!=null && head.val==val) {
			head = head.next;
		}
		if(head == null) {
			return head;
		}
		ListNode pnt = head;
		while(pnt!=null && pnt.next!=null) {
			while(pnt.next!=null && pnt.next.val==val) {
				pnt.next = pnt.next.next;
			}
			pnt = pnt.next;
		}
		return head;
	}

	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0), prev=dummy, pnt=head;
		dummy.next = head;
		while (pnt!=null) {
			if (pnt.val==val) {
				prev.next = pnt.next;
			} else {
				prev = pnt;
			}
			pnt = pnt.next;
		}

		return dummy.next;
	}
}
