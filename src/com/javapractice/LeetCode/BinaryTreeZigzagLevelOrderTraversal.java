/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
			return result;
		}
		
		boolean right = false;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while(!stack.empty()) {
			Stack<TreeNode> temp = new Stack<>();
			List<Integer> row = new ArrayList<>();
			while(!stack.empty()) {
				TreeNode node = stack.pop();
				if(right) {
					if(node.right != null) {
						temp.push(node.right);
					}
					if(node.left != null) {
						temp.push(node.left);
					}
				} else {
					if(node.left != null) {
						temp.push(node.left);
					}
					if(node.right != null) {
						temp.push(node.right);
					}
				}
				row.add(node.val);
			}
			if(right) {
				right = false;
			} else {
				right = true;
			}
			result.add(row);
			stack = temp;
		}
		
		return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
