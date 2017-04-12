/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * You may assume k is always valid, 1 lt k lt BST's total elements.
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 *
 */
public class KthSmallestElementInABST {
	public int kthSmallest(TreeNode root, int k) {
		ArrayList<Integer> list = new ArrayList<>();

		traversal(root, list);

		return list.get(k-1);
	}

	public void traversal(TreeNode root, ArrayList<Integer> list) {
		if(root.left!=null) {
			traversal(root.left, list);
		}
		list.add(root.val);
		if(root.right!=null) {
			traversal(root.right, list);
		}
	}
}
