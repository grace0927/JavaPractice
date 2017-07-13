/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://oj.leetcode.com/problems/path-sum/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		if(root.left == null && root.right == null) {
			return (root.val == sum);
		}
		if(root.left != null) {
			if(hasPathSum(root.left, sum-root.val)) {
				return true;
			}
		}
		if(root.right != null) {
			if(hasPathSum(root.right, sum-root.val)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPathSumIter(TreeNode root, int sum) {
		Queue<TreeNode> bfs = new LinkedList<>();
		if (root!=null) {
			bfs.add(root);
		}

		while (!bfs.isEmpty()) {
			TreeNode node = bfs.poll();
			if (node.left==null && node.right==null && node.val==sum) {
				return true;
			}
			if (node.left!=null) {
				node.left.val = node.left.val+node.val;
				bfs.add(node.left);
			}
			if (node.right!=null) {
				node.right.val = node.right.val+node.val;
				bfs.add(node.right);
			}
		}

		return false;
	}
}
