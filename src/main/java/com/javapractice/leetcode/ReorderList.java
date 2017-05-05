package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * https://oj.leetcode.com/problems/reorder-list/
 *
 * Given a singly linked list L: L0->L1->Ln-1->Ln,
 * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->...
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 */

public class ReorderList {
	public void reorderListOld(ListNode head) {
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

	public void reorderList(ListNode head) {
		if (isTwoNodesLess(head)) {
			return ;
		}

		ListNode mid=getMiddleNode(head), sec=reverseSecondHalf(mid);
		combine(head, sec);
	}

	private boolean isTwoNodesLess(ListNode head) {
		return head==null || head.next==null || head.next.next==null;
	}

	private ListNode getMiddleNode(ListNode head) {
		ListNode fast=head, slow=head;

		while (fast!=null && fast.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = slow.next;
		slow.next = null;

		return fast;
	}

	private ListNode reverseSecondHalf(ListNode node) {
		ListNode prev=null;

		while (node!=null) {
			ListNode next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}

		return prev;
	}

	private void combine(ListNode first, ListNode sec) {
		while (first!=null && sec!=null) {
			ListNode next = first.next;
			first.next = sec;
			first = next;
			next = sec.next;
			sec.next = first;
			sec = next;
		}
	}
}
