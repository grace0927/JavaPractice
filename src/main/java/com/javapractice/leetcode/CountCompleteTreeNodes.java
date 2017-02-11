/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * Given a complete binary tree, count the number of nodes.
 * In a complete binary tree every level, except possibly the last, 
 * is completely filled, and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = height(root, true);
        int right = height(root, false);
        if(left == right) {
            return (2<<(left-1))-1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public int height(TreeNode root, boolean left) {
        if(root == null) {
            return 0;
        }
        TreeNode pnt = root;
        int height = 0;
        while(pnt!=null) {
            pnt = (left)?pnt.left:pnt.right;
            height++;
        }
        return height;
    }
}
