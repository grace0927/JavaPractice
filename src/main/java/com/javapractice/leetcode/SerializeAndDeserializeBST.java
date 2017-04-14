/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later
 * in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string
 * and this string can be deserialized to the original tree structure.
 * The encoded string should be as compact as possible.
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 *
 */
public class SerializeAndDeserializeBST {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node==null) {
				sb.append("#");
			} else {
				queue.add(node.left);
				queue.add(node.right);
				sb.append(node.val);
			}
			sb.append(",");
		}

		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] array = data.split(",");
		if (array[0].equals("#")) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(array[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int index=1;

		while (index<array.length) {
			TreeNode node = queue.poll();
			if (!array[index].equals("#")) {
				TreeNode left = new TreeNode(Integer.parseInt(array[index]));
				node.left = left;
				queue.add(left);
			}
			index++;
			if (!array[index].equals("#")) {
				TreeNode right = new TreeNode(Integer.parseInt(array[index]));
				node.right = right;
				queue.add(right);
			}
			index++;
		}

		return root;
	}
}
