/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 * Example:
 * Input:
 * 1
 *  \
 *   3
 *  /
 * 2
 * Output: 1
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 *
 * Good Solution using advantage of structure of BST:
 * https://discuss.leetcode.com/topic/80823/two-solutions-in-order-traversal-and-a-more-general-way-using-treeset
 *
 */
public class MinimumAbsoluteDifferenceInBST {
	public int getMinimumDifference(TreeNode root) {
		PriorityQueue<TreeNode> heap = buildHeap(root);
		int min=Integer.MAX_VALUE, last=heap.poll().val;

		while(!heap.isEmpty()) {
			TreeNode node = heap.poll();
			min = Math.min(min, node.val-last);
			last = node.val;
		}

		return min;
	}

	public PriorityQueue<TreeNode> buildHeap(TreeNode root) {
		PriorityQueue<TreeNode> heap = new PriorityQueue<>(new Comparator<TreeNode>(){
			public int compare(TreeNode a, TreeNode b) {
				return a.val - b.val;
			}
		});
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node!=null) {
				heap.add(node);
				queue.add(node.left);
				queue.add(node.right);
			}
		}

		return heap;
	}
}
