/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Jianyu Feng
 *
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null) {
		} else if(root.left == null && root.right != null) {
			res.add(root.val);
			res.addAll(preorderTraversal(root.right));
		} else if(root.left != null && root.right == null) {
			res.add(root.val);
			res.addAll(preorderTraversal(root.left));
		} else if(root.left == null && root.right == null) {
			res.add(root.val);
		} else {
			res.add(root.val);
			res.addAll(preorderTraversal(root.left));
			res.addAll(preorderTraversal(root.right));
		}
		return res;
	}

	public List<Integer> preorderTraversalRecursively(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		preorderTraversalHelper(list, root);

		return list;
	}

	public void preorderTraversalHelper(List<Integer> list, TreeNode root) {
		if(root!=null) {
			list.add(root.val);
			preorderTraversalHelper(list, root.left);
			preorderTraversalHelper(list, root.right);
		}
	}

	public List<Integer> preorderTraversalIteratively(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if(root!=null) {
			stack.push(root);
		}

		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if(node.right!=null) {
				stack.push(node.right);
			}
			if(node.left!=null) {
				stack.push(node.left);
			}
		}

		return list;
	}
}
