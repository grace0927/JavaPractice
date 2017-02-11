/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 * 
 * reference: http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 */
public class BalancedBinaryTree {
	// calculate the height of tree
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return (left > right)?(left + 1):(right + 1);
    }
    
    // check if the the tree is height-balanced
    public boolean isBalanced(TreeNode root) {
    	// special case: NULL Tree
        if(root == null) {
            return true;
        }
        
        /*
         * height-balanced tree has height-balanced left, right trees.
         * and their height difference is at most 1
         * 
         */
        if(isBalanced(root.left)) {
            if(isBalanced(root.right)) {
                int left = height(root.left);
                int right = height(root.right);
                return ((left - right)<=1) && ((right-left)<=1);
            }
        }
        
        return false;
    }
}
