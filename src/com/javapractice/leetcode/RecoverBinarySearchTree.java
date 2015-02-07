/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. 
 * Could you devise a constant space solution?
 * Better Solution: Morris Traversal
 * ref: http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html
 *
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;
        
        if(root.left != null) {
            left = findMax(root.left);
        }
        if(root.right != null) {
            right = findMin(root.right);
        }
        
        if(left.val <= root.val && root.val <= right.val) {
            if(root.left != null) recoverTree(root.left);
            if(root.right != null) recoverTree(root.right);
        } else if(left.val > root.val && root.val <= right.val) {
            int temp = left.val;
            left.val = root.val;
            root.val = temp;
        } else if(left.val <= root.val && root.val > right.val) {
            int temp = right.val;
            right.val = root.val;
            root.val = temp;
        } else {
            int temp = right.val;
            right.val = left.val;
            left.val = temp;
        }
    }
    
    public TreeNode findMax(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;
        if(root.left != null) {
            left = findMax(root.left);
        }
        if(root.right != null) {
            right = findMax(root.right);
        }
        if(root.val > left.val) {
            if(root.val > right.val) {
                return root;
            } else {
                return right;
            }
        } else {
            if(left.val > right.val) {
                return left;
            } else {
                return right;
            }
        }
    }
    
    public TreeNode findMin(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;
        if(root.left != null) {
            left = findMin(root.left);
        }
        if(root.right != null) {
            right = findMin(root.right);
        }
        if(root.val < left.val) {
            if(root.val < right.val) {
                return root;
            } else {
                return right;
            }
        } else {
            if(left.val < right.val) {
                return left;
            } else {
                return right;
            }
        }
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
