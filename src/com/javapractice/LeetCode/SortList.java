/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/sort-list/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 */
public class SortList {
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
    public ListNode sortList(ListNode head) {
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
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
