/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * An example:
 *   2
 *  / \
 * 1   3
 *    /
 *   4
 *    \
 *     5
 * The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).
 *
 */
public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
		if(root == null) {
			return true;
		}
		if(root.left==null && root.right==null) {
			return true;
		}
		
		if(root.left != null) {
			if(!isValidBST(root.left)) {
				return false;
			}
			TreeNode temp = root.left;
			while(temp.right!=null) {
				temp = temp.right;
			}
			if(temp.val >= root.val) {
				return false;
			}
		}
		if(root.right != null) {
			if(!isValidBST(root.right)) {
				return false;
			}
			TreeNode temp = root.right;
			while(temp.left!=null) {
				temp = temp.left;
			}
			if(temp.val <= root.val) {
				return false;
			}
		}
		return true;
    }
}
