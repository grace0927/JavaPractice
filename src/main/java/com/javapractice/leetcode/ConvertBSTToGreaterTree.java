/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * Given a Binary Search Tree (BST),
 * convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 * Example:
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13

 *
 */
public class ConvertBSTToGreaterTree {
	public TreeNode convertBST(TreeNode root) {
		List<TreeNode> traverse = preorderTraverse(root);

		changeValue(traverse);

		return root;
	}

	public List<TreeNode> preorderTraverse(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();

		if (root!=null) {
			list.addAll(preorderTraverse(root.left));
			list.add(root);
			list.addAll(preorderTraverse(root.right));
		}

		return list;
	}

	public void changeValue(List<TreeNode> list) {
		for (int i=list.size()-2; i>=0; i--) {
			list.get(i).val += list.get(i+1).val;
		}
	}
}
