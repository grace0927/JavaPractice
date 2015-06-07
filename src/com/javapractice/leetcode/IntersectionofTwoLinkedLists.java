/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 �� a2
 *                    �K
 *                     c1 �� c2 �� c3
 *                    �J
 * B:     b1 �� b2 �� b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
			return null;
		}
		
		ListNode tempA = headA;
		ListNode tempB = headB;
		
		while(tempA != null && tempB != null) {
			if(tempA == tempB) {
				return tempA;
			}
			tempA = tempA.next;
			tempB = tempB.next;
		}
		
		if(tempA == null && tempB == null) {
			return null;
		} else if(tempA == null && tempB != null) {
			ListNode tempC = headB;
			tempA = headA;
			while(tempB != null) {
				tempB = tempB.next;
				tempC = tempC.next;
			}
			while(tempA != null && tempC != null && tempA != tempC) {
				tempA = tempA.next;
				tempC = tempC.next;
			}
			return tempA;
		} else {
			ListNode tempC = headA;
			tempB = headB;
			while(tempA != null) {
				tempA = tempA.next;
				tempC = tempC.next;
			}
			while(tempB != null && tempC != null && tempB != tempC) {
				tempB = tempB.next;
				tempC = tempC.next;
			}
			return tempB;
		}
    }
}
