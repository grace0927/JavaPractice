/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *        1
 *       / \
 *      2   3
 * Return 6.
 *
 */
public class BinaryTreeMaximumPathSum {
Integer result = new Integer(Integer.MIN_VALUE);
	
    public int maxPathSum(TreeNode root) {
        if(root == null) {
			return 0;
		}
		
		maxPathSumUtil(root);
		
		return result;
    }
	
	public int maxPathSumUtil(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int left = maxPathSumUtil(root.left);
		int right = maxPathSumUtil(root.right);
		
		int max = Math.max(root.val, Math.max(left+root.val, right+root.val));
		result = Math.max(result, Math.max(max, left+right+root.val));
		
		return max;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
		test.maxPathSum(new TreeNode(0));

	}

}
