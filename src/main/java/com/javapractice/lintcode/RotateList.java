/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 *
 */
public class RotateList {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head==null || head.next==null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(k > 0) {
            fast = fast.next==null?head:fast.next;
            k--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
