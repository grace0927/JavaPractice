/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Given binary tree {1,#,2,3}:
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,2,3].
 * Can you do it without recursion?
 *
 */
public class BinaryTreePreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
		ArrayList<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root!=null) {
			stack.push(root);
			while(!stack.empty()) {
				TreeNode temp = stack.pop();
				res.add(temp.val);
				if(temp.right!=null) {
				    stack.push(temp.right);
				}
				if(temp.left!=null) {
				    stack.push(temp.left);
				}
			}
		}
		return res;
    }
    
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversalRecursion(TreeNode root) {
        // write your code here
		ArrayList<Integer> res = new ArrayList<>();
		if(root!=null) {
		    res.add(root.val);
		}
		if(root!=null && root.left!=null) {
			res.addAll(preorderTraversal(root.left));
		}
		if(root!=null && root.right!=null) {
			res.addAll(preorderTraversal(root.right));
		}
		return res;
    }
}
