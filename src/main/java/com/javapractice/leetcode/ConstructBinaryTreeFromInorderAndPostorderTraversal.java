/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null) {
			return null;
		}
		
		int len = inorder.length;
		
		HashMap<Integer, Integer> in = new HashMap<>();
		for(int i=0; i<len; i++) {
			in.put(i, inorder[i]);
		}
		
		HashMap<Integer, Integer> post = new HashMap<>();
		for(int i=0; i<len; i++) {
			post.put(postorder[i], i);
		}
		
		return buildTreeUtil(in, post, 0, len);
    }
	
	public TreeNode buildTreeUtil(HashMap<Integer, Integer> in, HashMap<Integer, Integer> post, int start, int end) {
		if(end == start) {
			return null;
		}
		
		int rootIndex = -1;
		int rootValue = -1;
		int leftIndex = -1;
		
		for(int i=start; i<end; i++) {
			int curValue = in.get(i);
			int curIndex = post.get(curValue);
			if(curIndex > rootIndex) {
				rootIndex = curIndex;
				rootValue = curValue;
				leftIndex = i;
			}
		}
		
		TreeNode root = new TreeNode(rootValue);
		TreeNode left = buildTreeUtil(in, post, start, leftIndex);
		TreeNode right = buildTreeUtil(in, post, leftIndex+1, end);
		
		root.left = left;
		root.right = right;
		
		return root;
    }
}
