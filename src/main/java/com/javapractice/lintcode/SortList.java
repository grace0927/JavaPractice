/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/sort-list/
 * Sort a linked list in O(n log n) time using constant space complexity.
 * Given 1-3->2->null, sort it to 1->2->3->null.
 *
 */
public class SortList {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head==null || head.next==null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // divide
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        
        // merge
        ListNode pnt = new ListNode(0);
        ListNode res = pnt;
        while(left!=null && right!=null) {
            if(left.val > right.val) {
                pnt.next = right;
                pnt = pnt.next;
                right = right.next;
            } else {
                pnt.next = left;
                pnt = pnt.next;
                left = left.next;
            }
        }
        if(left == null) {
            pnt.next = right;
        }
        if(right == null) {
            pnt.next = left;
        }
        
        return res.next;
    }
}
