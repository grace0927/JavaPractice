/**
 * 
 */
package com.javapractice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/remove-node-in-binary-search-tree/
 * Given a root of Binary Search Tree with unique value for each node. 
 * Remove the node with given value.
 * If there is no such a node with given value in the binary search tree, do nothing.
 * You should keep the tree still a binary search tree after removal.
 * Given binary search tree:
 *         5
 *        / \
 *       3   6
 *      / \
 *     2   4 
 * Remove 3, you can either return:
 *         5
 *        / \
 *       2   6
 *        \
 *         4 
 * or :
 *         5
 *        / \
 *       4   6
 *      / 
 *     2    
 *
 */
public class RemoveNodeInBinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        // write your code here
		if(root == null) {
			return root;
		}
		if(root.val == value) {
			return rebuildTree(root);
		}
		if(root.val > value) {
			root.left = removeNode(root.left, value);
		}
		if(root.val < value) {
			root.right = removeNode(root.right, value);
		}
		return root;
    }
	
	public TreeNode rebuildTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		if(root.left == null) {
			return root.right;
		}
		if(root.right == null) {
			return root.left;
		}
		TreeNode cur = new TreeNode(root.right.val);
		cur.left = root.left;
		cur.right = root.right.right;
		Queue<TreeNode> queue = new LinkedList<>();
		if(root.right.left!=null) {
			queue.add(root.right.left);
		}
		while(!queue.isEmpty()) {
			if(queue.peek().left!=null) {
				queue.add(queue.peek().left);
			}
			if(queue.peek().right!=null) {
				queue.add(queue.peek().right);
			}
			insertNode(cur, queue.poll());
		}
		return cur;
	}
	
	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if(root == null) {
			return node;
		}
		if(root.left == null && root.val > node.val) {
			root.left = node;
			return root;
		}
		if(root.right == null && root.val < node.val) {
			root.right = node;
			return root;
		}
		if(root.val > node.val) {
			root.left = insertNode(root.left, node);
			return root;
		}
		if(root.val < node.val) {
			root.right = insertNode(root.right, node);
			return root;
		}
		return root;
    }
}
