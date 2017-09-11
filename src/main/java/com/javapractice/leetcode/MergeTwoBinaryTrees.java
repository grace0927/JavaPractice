/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/merge-two-binary-trees/
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 * Example 1:
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 *
 */
public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1==null || t2==null) {
			return t1==null ? t2 : t1;
		}

		t1.val += t2.val;
		Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
		q1.add(t1);
		q2.add(t2);

		while (!q1.isEmpty() || !q2.isEmpty()) {
			TreeNode n1=q1.poll(), n2=q2.poll();
			handleLeftNode(n1, n2, q1, q2);
			handleRightNode(n1, n2, q1, q2);
		}

		return t1;
	}

	protected void handleLeftNode(TreeNode n1, TreeNode n2, Queue<TreeNode> q1, Queue<TreeNode> q2) {
		if (n1.left==null) {
			n1.left = n2==null || n2.left==null ? null : new TreeNode(n2.left.val);
		} else {
			n1.left.val += n2==null || n2.left==null ? 0 : n2.left.val;
		}

		if (n1.left!=null) {
			q1.add(n1.left);
			q2.add(n2==null ? null : n2.left);
		}
	}

	protected void handleRightNode(TreeNode n1, TreeNode n2, Queue<TreeNode> q1, Queue<TreeNode> q2) {
		if (n1.right==null) {
			n1.right = n2==null || n2.right==null ? null : new TreeNode(n2.right.val);
		} else {
			n1.right.val += n2==null || n2.right==null ? 0 : n2.right.val;
		}

		if (n1.right!=null) {
			q1.add(n1.right);
			q2.add(n2==null ? null : n2.right);
		}
	}
}
