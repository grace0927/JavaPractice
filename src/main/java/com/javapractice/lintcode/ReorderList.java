/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/reorder-list/
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
 * reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 *
 */
public class ReorderList {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head==null || head.next==null || head.next.next==null) {
            return ;
        }
        ListNode pnt = head;
        while(pnt.next!=null && pnt.next.next!=null) {
            pnt = pnt.next;
        }
        ListNode second = head.next;
        head.next = pnt.next;
        pnt.next = null;
        reorderList(second);
        head.next.next = second;
        return ;
    }
}
