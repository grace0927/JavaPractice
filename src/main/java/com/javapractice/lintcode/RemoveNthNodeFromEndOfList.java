/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/remove-nth-node-from-end-of-list/
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Given linked list: 1->2->3->4->5->null, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5->null.
 * The minimum number of nodes in list is n.
 * O(n) time
 *
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode fast = head;
        while(n>0) {
            fast = fast.next;
            n--;
        }
        ListNode slow = head;
        if(fast==null) {
            return head.next;
        }
        while(fast!=null && fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null) {
            slow.next = slow.next.next;
        }
        
        return head;
    }
}
