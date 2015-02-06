/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.Stack;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if(root!=null) {
            if(root.next == null) {
                if(root.right != null && root.left != null) {
                    root.left.next = root.right;
                    root.right.next = null;
                } else if(root.right == null && root.left != null) {
                    root.left.next = null;
                } else if(root.right != null && root.left == null) {
                    root.right.next = null;
                } 
            } else {
                if(root.right != null && root.left != null) {
                    root.left.next = root.right;
					Stack<TreeLinkNode> temp = new Stack<>();
					temp.push(root);
					while(!temp.isEmpty()) {
						TreeLinkNode test = temp.pop();
						if(test.next != null) {
							if(test.next.left != null) {
								root.right.next = test.next.left;
								break;
							}
							if(test.next.right != null) {
								root.right.next = test.next.right;
								break;
							}
							temp.push(test.next);
						}
					}
                } else if(root.right == null && root.left != null) {
					Stack<TreeLinkNode> temp = new Stack<>();
					temp.push(root);
					while(!temp.isEmpty()) {
						TreeLinkNode test = temp.pop();
						if(test.next != null) {
							if(test.next.left != null) {
								root.left.next = test.next.left;
								break;
							}
							if(test.next.right != null) {
								root.left.next = test.next.right;
								break;
							}
							temp.push(test.next);
						}
					}
                } else if(root.right != null && root.left == null) {
					Stack<TreeLinkNode> temp = new Stack<>();
					temp.push(root);
					while(!temp.isEmpty()) {
						TreeLinkNode test = temp.pop();
						if(test.next != null) {
							if(test.next.left != null) {
								root.right.next = test.next.left;
								break;
							}
							if(test.next.right != null) {
								root.right.next = test.next.right;
								break;
							}
							temp.push(test.next);
						}
					}
                }
            }
            connect(root.right);
            connect(root.left);
        }
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
