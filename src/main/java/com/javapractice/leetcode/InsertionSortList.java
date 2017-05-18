/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 *
 * https://oj.leetcode.com/problems/insertion-sort-list/
 *
 * Sort a linked list using insertion sort.
 *
 */
public class InsertionSortList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public ListNode insertionSortListOld(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode result = new ListNode(head.val);
		head = head.next;
		ListNode indicater;

		while(head != null) {
			ListNode newNode = new ListNode(head.val); // create new node
			indicater = result;

			// search for correct place for the new node
			// the previous value is smaller than it while the next value is larger than its value
			while(indicater!= null) {

				if(indicater.next == null) {
					if(indicater.val < newNode.val) {
						indicater.next = newNode;
						break;
					} else {
						int temp = indicater.val;
						indicater.val = newNode.val;
						newNode.val = temp;
						indicater.next = newNode;
						break;
					}
				}

				if(indicater.val < newNode.val && indicater.next.val > newNode.val) {
					newNode.next = indicater.next;
					indicater.next = newNode;
					break;
				}

				if(indicater.val > newNode.val) {
					int temp = indicater.val;
					indicater.val = newNode.val;
					newNode.val = temp;
					newNode.next = indicater.next;
					indicater.next = newNode;
					break;
				}

				indicater = indicater.next;
			}

			// insert new node into correct place

			head = head.next;
		}

		return result;
	}

	public ListNode insertionSortList(ListNode head) {
		ListNode dummy=new ListNode(0);

		while (head!=null) {
			ListNode pnt=dummy, node=new ListNode(head.val);
			while (pnt.next!=null && pnt.next.val<head.val) {
				pnt = pnt.next;
			}
			if (pnt.next==null) {
				pnt.next = node;
			} else {
				ListNode next = pnt.next;
				pnt.next = node;
				node.next = next;
			}
			head = head.next;
		}

		return dummy.next;
	}
}
