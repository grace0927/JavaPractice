/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/insert-node-in-a-binary-search-tree/
 * Given a binary search tree and a new tree node, insert the node into the tree.
 * You should keep the tree still be a valid binary search tree.
 * Given binary search tree as follow, after Insert node 6, the tree should be:
 *   2             2
 *  / \           / \
 * 1   4   -->   1   4
 *    /             / \ 
 *   3             3   6
 * Can you do it without recursion?
 *
 */
public class InsertNodeInABinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
		if(root==null) {
			return node;
		}
		TreeNode pnt = root;
		while(pnt!=null) {
			if(pnt.val > node.val) {
				if(pnt.left != null) {
					pnt = pnt.left;
				} else {
					pnt.left = node;
					return root;
				}
			} else {
				if(pnt.right != null) {
					pnt = pnt.right;
				} else {
					pnt.right = node;
					return root;
				}
			}
		}
		return root;
    }
}
