/**
 *
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 */
public class FindBottomLeftTreeValue {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		return traversalLevelByLevel(queue);
	}

	public int traversalLevelByLevel(Queue<TreeNode> queue) {
		int left = queue.peek().val;

		Queue<TreeNode> nextLevel = buildNextLevel(queue);

		return nextLevel.isEmpty() ? left : traversalLevelByLevel(nextLevel);
	}

	public Queue<TreeNode> buildNextLevel(Queue<TreeNode> queue) {
		Queue<TreeNode> nextLevel = new LinkedList<>();

		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.left!=null) {
				nextLevel.add(node.left);
			}
			if(node.right!=null) {
				nextLevel.add(node.right);
			}
		}

		return nextLevel;
	}
}
