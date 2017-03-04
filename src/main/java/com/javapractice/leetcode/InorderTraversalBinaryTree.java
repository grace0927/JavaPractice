/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jianyu Feng
 *
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * confused what "{1,#,2,3}" means?
 * OJ's Binary Tree Serialization:
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * Here's an example:
 *    1
 *   / \
 *  2   3
 *     /
 *    4
 *     \
 *      5
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 *
 */

public class InorderTraversalBinaryTree {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null) {
		} else if(root.left == null && root.right != null) {
			res.add(root.val);
			res.addAll(inorderTraversal(root.right));
		} else if(root.left != null && root.right == null) {
			res.addAll(inorderTraversal(root.left));
			res.add(root.val);
		} else if(root.left == null && root.right == null) {
			res.add(root.val);
		} else {
			res.addAll(inorderTraversal(root.left));
			res.add(root.val);
			res.addAll(inorderTraversal(root.right));
		}
		return res;
	}

	public List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		traversalHelper(list, root);

		return list;
	}

	public void traversalHelper(List<Integer> list, TreeNode node) {
		if (node!=null) {
			traversalHelper(list, node.left);
			list.add(node.val);
			traversalHelper(list, node.right);
		}
	}

	public List<Integer> inorderTraversalIteratively(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root!=null) {
			stack.push(root);
		}

		while (!stack.isEmpty()) {
			while (stack.peek().left!=null) {
				TreeNode left = stack.peek().left;
				stack.peek().left = null;
				stack.push(left);
			}
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right!=null) {
				stack.push(node.right);
			}
		}

		return list;
	}

	public List<Integer> inorderTraversalIterativelyWithoutNodeChange(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;

		while (current!=null || !stack.empty()){
			while (current!=null){
				stack.add(current);
				current = current.left;
			}
			current = stack.pop();
			list.add(current.val);
			current = current.right;
		}

		return list;
	}
}
