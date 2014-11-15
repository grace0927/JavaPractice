/**
 * 
 */
package leetCode;

import java.util.ArrayList;

/**
 * @author jianyu
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
