/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/invert-binary-tree/
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root!=null) {
			TreeNode right = root.right;
			root.right = invertTree(root.left);
			root.left = invertTree(right);
		}

		return root;
	}
}
