/**
 * 
 */
package leetCode;

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
        if(preorder == null) {
			return null;
		}
		
		int len = preorder.length;
		int ic = 0;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);
		
		for(int pc=1; pc<len; pc++) {
			TreeNode cur = new TreeNode(preorder[pc]);
			if(stack.peek().val == inorder[ic]) {
				stack.pop();
				ic++;
				continue;
			} else {
				stack.peek().right = cur;
				stack.push(cur);
			}
		}
		
		return root;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
