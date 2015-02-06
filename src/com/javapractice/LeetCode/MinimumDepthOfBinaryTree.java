/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) {
			return 0;
		}
		Queue<TreeNode> row = new LinkedList<>();
		row.add(root);
		int level = 0;
		
		while(!row.isEmpty()) {
			level++;
			Queue<TreeNode> temp = new LinkedList<>();
			while(!row.isEmpty()) {
				TreeNode test = row.poll();
				if(test.left == null && test.right == null) {
					return level;
				}
				if(test.left != null) {
					temp.add(test.left);
				}
				if(test.right != null) {
					temp.add(test.right);
				}
			}
			row = temp;
		}
		
		return level;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
