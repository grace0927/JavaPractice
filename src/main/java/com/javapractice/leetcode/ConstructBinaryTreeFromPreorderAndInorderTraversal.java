/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) {
			return null;
		}
		
		int len = preorder.length;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<len; i++) {
		    map.put(inorder[i], i);
		}
		
		for(int pc=1; pc<len; pc++) {
			TreeNode cur = new TreeNode(preorder[pc]);
			int curIndex = map.get(cur.val);
			int topIndex = map.get(stack.peek().val);
			if(curIndex < topIndex) {
			    stack.peek().left = cur;
			    stack.push(cur);
			} else {
			    TreeNode top = stack.pop();
			    while(!stack.empty() && curIndex > map.get(stack.peek().val)) {
			        top = stack.pop();
			    }
			    top.right = cur;
			    stack.push(cur);
			}
		}
		
		return root;
    }
	
	public TreeNode buildTreeFast(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) {
			return null;
		}
		
		int len = preorder.length;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);
		boolean right = false;
		TreeNode top = stack.peek();
		
		for(int pc=1, ic=0; pc<len; pc++) {
			TreeNode cur = new TreeNode(preorder[pc]);
			// keep pop stack when preorder match inorder
			if(!stack.empty() && stack.peek().val == inorder[ic]) {
			    top = stack.pop();
			    right = true;
			    ic++;
			    pc--;
			} else {
			    if(right) {
			        right = false;
			        top.right = cur;
			        stack.push(cur);
			    } else {
			        stack.peek().left = cur;
			        stack.push(cur);
			    }
			}
		}
		
		return root;
    }
	
	public TreeNode buildTreeRecursive(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, inorder, 0, 0, inorder.length);
    }
    
    public TreeNode buildTreeUtil(int[] preorder, int[] inorder, int ps, int is, int ie) {
        if(ps > preorder.length-1 || ie < is) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = 0;
        for(int i=is; i<=ie; i++) {
            if(inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        root.left = buildTreeUtil(preorder, inorder, ps+1, is, rootIndex-1);
        root.right = buildTreeUtil(preorder, inorder, ps+rootIndex-is+1, rootIndex+1, ie);
        
        return root;
    }
}
