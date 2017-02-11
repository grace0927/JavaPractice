/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
 * A)  3            B)    3 
 *    / \                  \
 *   9  20                 20
 *     /  \                / \
 *    15   7              15  7
 * The binary tree A is a height-balanced binary tree, but B is not.
 *
 */
public class BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
		if(root == null) {
			return true;
		}
		if(root.left == null && root.right == null) {
			return true;
		}
		if(root.left != null) {
			if(!isBalanced(root.left)) {
				return false;
			}
		}
		if(root.right != null) {
			if(!isBalanced(root.right)) {
				return false;
			}
		}
		if(Math.abs(getHeight(root.left)-getHeight(root.right)) > 1) {
			return false;
		}
		return true;
    }
	
	public int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		int left = getHeight(root.left)+1;
		int right = getHeight(root.right)+1;
		
		return Math.max(left, right);
	}
}
