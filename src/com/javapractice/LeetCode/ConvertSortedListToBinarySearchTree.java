/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * ref: http://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
 *
 */
public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
        int count = countList(head);
		return sortedListToBSTUtil(head, count);
    }
	
	public int countList(ListNode head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	public TreeNode sortedListToBSTUtil(ListNode head, int count) {
		if(count <=0) {
			return null;
		}
		
		TreeNode left = sortedListToBSTUtil(head, count/2);
		for(int i=0; i<count/2; i++) {
			head = head.next;
		}
		TreeNode root = new TreeNode(head.val);
		root.left = left;
		head = head.next;
		TreeNode right = sortedListToBSTUtil(head, count - count/2 - 1);
		root. right = right;
		return root;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
