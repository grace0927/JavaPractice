/**
 * 
 */
package com.javapractice.lintcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Given in-order [1,2,3] and pre-order [2,1,3], return a tree:
 *   2
 *  / \
 * 1   3
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
		int len = preorder.length;
		if(len <= 0) {
			return null;
		}
		if(len == 1) {
			return new TreeNode(preorder[0]);
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<len; i++) {
			map.put(inorder[i], i);
		}
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);
		
		for(int i=1; i<len; i++) {
			TreeNode temp = new TreeNode(preorder[i]);
			if(!stack.isEmpty()) {
				if(map.get(stack.peek().val) > map.get(temp.val)) {
					stack.peek().left = temp;
					stack.push(temp);
				} else {
				    TreeNode cur = stack.pop();
				    while(!stack.isEmpty() && map.get(stack.peek().val) < map.get(temp.val)) {
				        cur = stack.pop();
				    }
				    cur.right = temp;
				    stack.push(temp);
				    
				}
			} else {
				stack.push(temp);
			}
		}
		
		return root;
    }
}
