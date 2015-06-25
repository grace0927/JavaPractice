/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list/
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head==null || head.next==null) {
            return head;
        }
        ListNode pointer = head;
        int cur = head.val;
        while(pointer!=null && pointer.next!=null) {
            if(pointer.next.val == cur) {
                pointer.next = pointer.next.next;
            } else {
                cur = pointer.next.val;
                pointer = pointer.next;
            }
        }
        return head;
    }
}
