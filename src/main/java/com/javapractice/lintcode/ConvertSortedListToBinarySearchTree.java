/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/convert-sorted-list-to-binary-search-tree/
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 */
public class ConvertSortedListToBinarySearchTree {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        int cnt = 0;
        ListNode pnt = head;
        while(pnt != null) {
            cnt++;
            pnt = pnt.next;
        }
        cnt /= 2;
        pnt = head;
        while(cnt > 1) {
            pnt = pnt.next;
            cnt--;
        }
        TreeNode root = new TreeNode(pnt.next.val);
        root.right = sortedListToBST(pnt.next.next);
        pnt.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
