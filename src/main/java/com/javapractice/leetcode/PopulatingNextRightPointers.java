/**
 *
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * Given a binary tree
 *
 * struct TreeLinkNode {
 *    TreeLinkNode *left;
 *    TreeLinkNode *right;
 *    TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *       1
 *     /  \
 *    2    3
 *   / \  / \
 *  4  5  6  7
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *     /  \
 *    2 -> 3 -> NULL
 *   / \  / \
 *  4->5->6->7 -> NULL
 *
 */
public class PopulatingNextRightPointers {

	/**
	 * Definition for binary tree with next pointer.
	 * public class TreeLinkNode {
	 *     int val;
	 *     TreeLinkNode left, right, next;
	 *     TreeLinkNode(int x) { val = x; }
	 * }
	 */

	public void connectOld(TreeLinkNode root) {
		if(root!=null) {
			if(root.next == null) {
				if(root.right != null && root.left != null) {
					root.left.next = root.right;
					root.right.next = null;
				} else if(root.right == null && root.left != null) {
					root.left.next = null;
				} else if(root.right != null && root.left == null) {
					root.right.next = null;
				}
			} else {
				if(root.right != null && root.left != null) {
					root.left.next = root.right;
					root.right.next = root.next.left;
				} else if(root.right == null && root.left != null) {
					root.left.next = root.next.left;
				} else if(root.right != null && root.left == null) {
					root.right.next = root.next.left;
				}
			}
			connectRecursive(root.right);
			connectRecursive(root.left);
		}
	}

	public void connectIterative(TreeLinkNode root) {
		if (root==null) {
			return ;
		}

		Queue<TreeLinkNode> level = new LinkedList<>();
		level.add(root);
		while (!level.isEmpty()) {
			Queue<TreeLinkNode> nextLevel = new LinkedList<>();
			while (!level.isEmpty()) {
				TreeLinkNode node = level.poll();
				node.next = level.isEmpty() ? null : level.peek();

				if (node.left!=null) {
					nextLevel.add(node.left);
				}

				if (node.right!=null) {
					nextLevel.add(node.right);
				}
			}
			level = nextLevel;
		}
	}

	public void connectRecursive(TreeLinkNode root) {
		if (root==null) {
			return ;
		}

		connectRecursive(root.left);
		connectRecursive(root.right);

		root.next = null;
		TreeLinkNode left=root.left, right=root.right;
		while (left!=null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
	}
}
