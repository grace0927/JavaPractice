/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class PostorderTraversalBinaryTree {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    public List<Integer> postorderTraversal(TreeNode root) {
        
        if(root == null) {
			List<Integer> res = Collections.emptyList();
			return res;
		}
		
        List<Integer> result = new LinkedList<>();
        
        if(root.left != null) {
            List<Integer> left = postorderTraversal(root.left);
            result.addAll(left);
        }
        if(root.right != null) {
            List<Integer> right = postorderTraversal(root.right);
            result.addAll(right);
        }
        if(root != null) result.add(root.val);
        
        return result;
    }
}
