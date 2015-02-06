/**
 * 
 */
package com.javapractice.LeetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        if(root == null) {
			return true;
		}
		if(root.left == null && root.right == null) {
			return true;
		}
		if(root.left != null) {
			if(!isValidBST(root.left)) {
				return false;
			}
			if(findMax(root.left) >= root.val) {
				return false;
			}
		}
		if(root.right != null) {
			if(!isValidBST(root.right)) {
				return false;
			}
			if(findMin(root.right) <= root.val) {
				return false;
			}
		}
		
		return true;
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidateBinarySearchTree test = new ValidateBinarySearchTree();
		TreeNode one = new TreeNode(5);
		TreeNode two = new TreeNode(14);
		TreeNode three = new TreeNode(1);
		
		one.left = two;
		two.left = three;

		test.isValidBST(one);
	}

}
