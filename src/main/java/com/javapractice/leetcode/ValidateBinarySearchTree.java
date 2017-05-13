/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author Jianyu Feng
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Good Ref:
 * https://discuss.leetcode.com/topic/46016/
 * learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-java-solution
 * https://discuss.leetcode.com/topic/7179/my-simple-java-solution-in-3-lines
 *
 */
public class ValidateBinarySearchTree {
	public boolean isValidBSTOld(TreeNode root) {
		if(oneOrLessNodes(root)) {
			return true;
		}

		if(root.left != null) {
			if(!isValidBST(root.left) || findMax(root.left) >= root.val) {
				return false;
			}
		}

		if(root.right != null) {
			if(!isValidBST(root.right) || findMin(root.right) <= root.val) {
				return false;
			}
		}

		return true;
	}

	private boolean oneOrLessNodes(TreeNode root) {
		return root==null || (root.left==null && root.right==null);
	}

	public int findMin(TreeNode root) {
		if(root.left == null && root.right == null) {
			return root.val;
		}

		int min = root.val;
		if(root.left != null) {
			min = Math.min(findMax(root.left), min);
		}

		if(root.right != null) {
			min = Math.min(findMax(root.right), min);
		}

		return min;
	}

	public int findMax(TreeNode root) {
		if(root.left == null && root.right == null) {
			return root.val;
		}

		int max = root.val;
		if(root.left != null) {
			max = Math.max(findMax(root.left), max);
		}

		if(root.right != null) {
			max = Math.max(findMax(root.right), max);
		}

		return max;
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, new HashMap<>());
	}

	private boolean isValidBSTHelper(TreeNode root, HashMap<TreeNode, Integer[]> map) {
		if (root==null) {
			return true;
		}

		int min=root.val, max=root.val;
		if (root.left!=null) {
			if (!isValidBSTHelper(root.left, map) || root.val<=map.get(root.left)[1]) {
				return false;
			}
			min = map.get(root.left)[0];
		}

		if (root.right!=null) {
			if (!isValidBSTHelper(root.right, map) || root.val>=map.get(root.right)[0]) {
				return false;
			}
			max = map.get(root.right)[1];
		}
		map.put(root, new Integer[]{min, max});

		return true;
	}
}
