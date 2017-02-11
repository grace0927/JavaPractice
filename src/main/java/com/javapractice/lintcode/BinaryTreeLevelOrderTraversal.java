/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/binary-tree-level-order-traversal/
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * Challenge
 * Using only 1 queue to implement it.
 *
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		while(!queue.isEmpty()) {
			ArrayList<Integer> cur = new ArrayList<>();
			while(queue.peek()!=null) {
			    TreeNode temp = queue.poll();
				if(temp.left!=null) {
					queue.add(temp.left);
				}
				if(temp.right!=null) {
					queue.add(temp.right);
				}
				cur.add(temp.val);
			}
			queue.poll();
			if(!cur.isEmpty()) {
			    queue.add(null);
				res.add(cur);
			}
		}
		return res;
    }
}
