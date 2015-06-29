/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/linked-list-cycle/
 * Given a linked list, determine if it has a cycle in it.
 * Given -21->10->4->5, tail connects to node index 1, return true
 * Follow up:
 * Can you solve it without using extra space?
 *
 */
public class LinkedListCycle {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if(head == null || head.next == null || head.next.next == null) {
            return false;
        }
        
        ListNode pntFast = head.next.next;
        ListNode pntSlow = head.next;
        while(pntFast.next!=null && pntFast.next.next!=null) {
            if(pntFast == pntSlow) {
                return true;
            }
            pntFast = pntFast.next.next;
            pntSlow = pntSlow.next;
        }
        
        return false;
    }
}
