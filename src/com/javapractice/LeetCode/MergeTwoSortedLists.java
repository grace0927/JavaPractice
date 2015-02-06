/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * 
 */

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // special cases
        if(l1 == null && l2 == null) {
            return null;
        } else if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else {
            ListNode res;
            ListNode tmp;
            
            // initial first node
            if(l1.val > l2.val) {
                res = l2;
                l2 = l2.next;
                tmp = res;
            } else {
                res = l1;
                l1 = l1.next;
                tmp = res;
            }
            
            // compare and add nodes
            while(l1 != null && l2 != null) {
                if(l1.val > l2.val) {
                    tmp.next = l2;
                    l2 = l2.next;
                    tmp = tmp.next;
                } else {
                    tmp.next = l1;
                    l1 = l1.next;
                    tmp = tmp.next;
                }
            }
            
            // add rest of left list
            if(l1 == null) {
                tmp.next = l2;
            } else {
                tmp.next = l1;
            }
            
            return res;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
