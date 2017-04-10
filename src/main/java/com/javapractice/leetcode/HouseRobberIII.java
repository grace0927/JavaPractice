/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/house-robber-iii/
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police
 * if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
 *   3
 *  / \
 * 2   3
 *  \   \
 *   3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *     3
 *    / \
 *   4   5
 *  / \   \
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 */
public class HouseRobberIII {
	public int robOld(TreeNode root) {
		if(root==null) {
			return 0;
		}

		int left = rob(root.left);
		int right = rob(root.right);
		int base = root.val;
		if(root.left!=null) {
			base += rob(root.left.left);
			base += rob(root.left.right);
		}
		if(root.right!=null) {
			base += rob(root.right.left);
			base += rob(root.right.right);
		}

		return Math.max(base, left+right);
	}

	public int rob(TreeNode root) {
		if (root==null) {
			return 0;
		}

		int left=rob(root.left), right=rob(root.right);
		addValue(root, root.left);
		addValue(root, root.right);
		root.val = Math.max(left+right, root.val);

		return root.val;
	}

	public void addValue(TreeNode root, TreeNode node) {
		if (node!=null) {
			root.val += node.left==null ? 0 : node.left.val;
			root.val += node.right==null ? 0 : node.right.val;
		}
	}
}
