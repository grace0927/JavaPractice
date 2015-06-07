/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/binary-search-tree-iterator/
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 */
public class BinarySearchTreeIterator {
	private TreeNode cur;
	private Stack<TreeNode> stack = new Stack<>();
	
    public BinarySearchTreeIterator(TreeNode root) {
		cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while(cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		if(stack.empty()) {
			return false;
		}
		return true;
    }

    /** @return the next smallest number */
    public int next() {
        cur = stack.pop();
		int temp = cur.val;
		cur = cur.right;
		return temp;
    }
}
