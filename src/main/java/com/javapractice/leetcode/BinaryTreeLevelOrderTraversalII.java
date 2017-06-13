/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jianyu Feng
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 */
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if(root != null) {
			Queue<TreeNode> rowQueue = new LinkedList<>();
			rowQueue.add(root);
			while(!rowQueue.isEmpty()) {
				List<Integer> row = new ArrayList<>();
				for(TreeNode node:rowQueue) {
					row.add(node.val);
				}
				result.add(0, row);
				Queue<TreeNode> temp = new LinkedList<>();
				while(!rowQueue.isEmpty()) {
					TreeNode tempNode = rowQueue.poll();
					if(tempNode.left != null) {
						temp.add(tempNode.left);
					}
					if(tempNode.right != null) {
						temp.add(tempNode.right);
					}
				}
				rowQueue = temp;
			}
		}

		return result;
	}

}
