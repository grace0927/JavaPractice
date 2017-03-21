/*
 *
 */

package com.javapractice.leetcode;

/**
 *
 * @author Jianyu Feng
 *
 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		int depth = 0;

		if(root != null) {
			depth = 1;
			int deltaLeft = 0;
			int deltaRight = 0;
			if(root.left != null) {
				deltaLeft = maxDepth(root.left);
			}
			if(root.right != null) {
				deltaRight = maxDepth(root.right);
			}
			if(deltaLeft > deltaRight) {
				depth += deltaLeft;
			} else {
				depth += deltaRight;
			}
		}

		return depth;
	}

	public int maxDepthRecursive(TreeNode root) {
		if(root==null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

	public int maxDepth(TreeNode root) {
		int depth = 0;
		Queue<TreeNode> level = new LinkedList<>();

		if(root!=null) {
			level.add(root);
		}

		while(!level.isEmpty()) {
			Queue<TreeNode> nextLevel = new LinkedList<>();
			while(!level.isEmpty()) {
				TreeNode node = level.poll();
				if(node.left!=null) {
					nextLevel.add(node.left);
				}
				if(node.right!=null) {
					nextLevel.add(node.right);
				}
			}
			level = nextLevel;
			depth++;
		}

		return depth;
	}
}
