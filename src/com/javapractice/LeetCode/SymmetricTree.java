/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/symmetric-tree/
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *     3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 *
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
    	// special case
        if(root == null) {
            return true;
        }
        return isSymmetricUtil(root.left, root.right);
    }
    
    public boolean isSymmetricUtil(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        
        // check if two brunches are symmetric
        return isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
    }
    
    
    // Iteratively way using queue
    public boolean isSymmetricIteratively(TreeNode root) {
    	// special case
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        if(root.left == null || root.right == null) {
            return false;
        }
        
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        
        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
        	TreeNode left = leftQueue.poll();
        	TreeNode right = rightQueue.poll();
        	
        	if(left == null && right == null) {
        		continue;
        	}
        	if(left == null || right == null) {
                return false;
            }
        	if(left.val != right.val) {
        		return false;
        	}
        	
        	leftQueue.add(left.left);
        	leftQueue.add(left.right);
        	rightQueue.add(right.right);
        	rightQueue.add(right.left);
        }
        return true;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
