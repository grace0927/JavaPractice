/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/sum-of-left-leaves/
 * Find the sum of all left leaves in a given binary tree.
 * Example:
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 */
public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		Stack<TreeNode> traversalStack = new Stack<>();
		Stack<Boolean> leftStack = new Stack<>();
		int sum = 0;

		if (root!=null) {
			traversalStack.push(root);
			leftStack.push(false);

			while (!traversalStack.isEmpty()) {
				TreeNode node = traversalStack.pop();
				Boolean left  = leftStack.pop();

				if (node.left==null && node.right==null && left) {
					sum += node.val;
				}

				if (node.left!=null) {
					traversalStack.push(node.left);
					leftStack.push(true);
				}

				if (node.right!=null) {
					traversalStack.push(node.right);
					leftStack.push(false);
				}
			}
		}

		return sum;
	}
}
