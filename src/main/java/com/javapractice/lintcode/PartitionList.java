/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/partition-list/
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 *
 */
public class PartitionList {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode left = new ListNode(0);
        ListNode leftAlter = left;
        ListNode right = new ListNode(0);
        ListNode rightAlter = right;
        
        while(head != null) {
            if(head.val >= x) {
                ListNode cur = new ListNode(head.val);
                rightAlter.next = cur;
                rightAlter = cur;
            } else {
                ListNode cur = new ListNode(head.val);
                leftAlter.next = cur;
                leftAlter = cur;
            }
            head = head.next;
        }
        leftAlter.next = right.next;
        return left.next;
    }
}
