/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/sort-list/
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head==null || head.next==null) {
			return head;
		}

		ListNode mid = findMiddleAndSplitList(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return merge(left, right);
	}

	private ListNode findMiddleAndSplitList(ListNode head) {
		ListNode fast=head, slow=head, prev=slow;
		while(fast!=null && fast.next!=null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		prev.next = null;

		return slow;
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy=new ListNode(0), pnt=dummy;
		while(left!=null && right!=null) {
			if (left.val>right.val) {
				pnt.next = right;
				right = right.next;
			} else {
				pnt.next = left;
				left = left.next;
			}
			pnt = pnt.next;
		}
		if (left!=null || right!=null) {
			pnt.next = (left!=null) ? left : right;
		}

		return dummy.next;
	}

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public ListNode sortListOld(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode first = head;
		ListNode second = head;
		while(second.next!=null && second.next.next!=null) {
			first = first.next;
			second = second.next.next;
		}

		second = first.next;
		first.next = null;

		return mergeList(sortList(head),sortList(second));

	}

	public ListNode mergeList(ListNode one, ListNode two) {
		if(one==null) {
			return two;
		}
		if(two == null) {
			return one;
		}

		ListNode tmp;

		if(one.val > two.val) {
			tmp = new ListNode(two.val);
			two = two.next;
		} else {
			tmp = new ListNode(one.val);
			one = one.next;
		}

		ListNode three = tmp;

		while(one!=null && two!=null) {
			if(one.val > two.val) {
				ListNode temp = new ListNode(two.val);
				tmp.next = temp;
				tmp = temp;
				two = two.next;
			} else {
				ListNode temp = new ListNode(one.val);
				tmp.next = temp;
				tmp = temp;
				one = one.next;
			}
		}

		tmp.next = (one==null)?two:one;

		return three;
	}

}
