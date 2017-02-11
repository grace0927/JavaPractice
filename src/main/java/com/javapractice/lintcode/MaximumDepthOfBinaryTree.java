/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Given a binary tree as follow:
 *   1
 *  / \ 
 * 2   3
 *    / \
 *   4   5 
 * The maximum depth is 3.
 *
 */
public class MaximumDepthOfBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null) {
            return 0;
        }
        if(root.left==null && root.right==null) {
            return 1;
        }
        
        int left = maxDepth(root.left)+1;
        int right = maxDepth(root.right)+1;
        
        return (left>right)?left:right;
    }
}
