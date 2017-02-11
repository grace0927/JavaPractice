/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/remove-linked-list-elements/
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
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
}
