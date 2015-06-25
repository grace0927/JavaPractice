/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/merge-two-sorted-lists/
 * Merge two sorted (ascending) linked lists and return it as a new sorted list.
 * The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.
 * Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
 *
 */
public class MergeTwoSortedLists {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode res = new ListNode(0);
        ListNode pointer = res;
        while(l1!=null && l2!=null) {
            if(l1.val < l2.val) {
                ListNode cur = new ListNode(l1.val);
                pointer.next = cur;
                l1 = l1.next;
            } else {
                ListNode cur = new ListNode(l2.val);
                pointer.next = cur;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if(l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }
        return res.next;
    }
}
