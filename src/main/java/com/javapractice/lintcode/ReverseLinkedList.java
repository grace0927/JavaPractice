/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/reverse-linked-list/
 * Reverse a linked list.
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 * Reverse it in-place and in one-pass
 *
 */
public class ReverseLinkedList {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head==null || head.next==null) {
            return head;
        }
        ListNode pnt = head.next;
        head.next = null;
        while(pnt != null) {
            ListNode temp = pnt.next;
            pnt.next = head;
            head = pnt;
            pnt = temp;
        }
        return head;
    }
}
