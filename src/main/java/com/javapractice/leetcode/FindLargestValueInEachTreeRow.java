/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * You need to find the largest value in each row of a binary tree.
 *
 */
public class FindBottomLeftTreeValue {
	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> level = new LinkedList<>();
		List<Integer> result = new ArrayList<>();

		if(root!=null) {
			level.add(root);

			traversalBreadthFirstAndBuild(level, result);
		}

		return result;
	}

	public void traversalBreadthFirstAndBuild(Queue<TreeNode> level, List<Integer> result) {
		Queue<TreeNode> nextLevel = new LinkedList<>();
		int maxValue = Integer.MIN_VALUE;

		while(!level.isEmpty()) {
			TreeNode node = level.poll();
			maxValue = Math.max(maxValue, node.val);
			if(node.left!=null) {
				nextLevel.add(node.left);
			}
			if(node.right!=null) {
				nextLevel.add(node.right);
			}
		}
		result.add(maxValue);

		if(!nextLevel.isEmpty()) {
			traversalBreadthFirstAndBuild(nextLevel, result);
		}
	}
}
