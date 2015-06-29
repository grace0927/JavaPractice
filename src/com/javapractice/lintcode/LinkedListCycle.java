/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
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
