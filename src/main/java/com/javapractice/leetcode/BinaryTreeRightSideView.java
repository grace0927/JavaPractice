/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jianyu
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 *
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
		if(root == null) {
			return list;
		}
		if(root.left==null && root.right==null) {
			list.add(root.val);
			return list;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode end = new TreeNode(0);
		queue.add(end);
		
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if(cur == end) {
				continue;
			}
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
			if(queue.peek() == end) {
				list.add(cur.val);
				queue.add(end);
			}
		}
		
		return list;
    }
}
