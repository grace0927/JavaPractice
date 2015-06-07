/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 *  
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 */
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
        if(head == null) {
            // special case 1: Link List with none node
            return null;
        } else if(head.next == null) {
            // special case 2: Link List with one node
            return head;
        } else {
            ListNode one = head;
            ListNode two = head.next;
            
            // front boundary handle
            head = two;
            one.next = swapPairs(two.next);
            two.next = one;
            
            return head;
        }
    }
}
