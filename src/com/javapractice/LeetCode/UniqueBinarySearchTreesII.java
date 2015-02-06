/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3,  your program should return all 5 unique BST's shown below.
 *    1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 *
 */

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
        return generateTreesUtil(1, n);
    }
	
	public List<TreeNode> generateTreesUtil(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		if(end < start) {
		    result.add(null);
		} else if(end == start) {
			TreeNode root = new TreeNode(end);
			result.add(root);
		} else {
	    	for(int i=start; i<=end; i++) {
    			for(TreeNode left:generateTreesUtil(start, i-1)) {
				    for(TreeNode right:generateTreesUtil(i+1, end)) {
					    TreeNode root = new TreeNode(i);
					    root.left = left;
					    root.right = right;
					    result.add(root);
				    }
			    }
		    }
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
