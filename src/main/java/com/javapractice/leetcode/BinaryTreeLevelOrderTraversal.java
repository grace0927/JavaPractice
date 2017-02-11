/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author feng
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> rowQueue = new LinkedList<>();
        if(root == null) {
            return result;
        }
        rowQueue.add(root);
        while(!rowQueue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            for(TreeNode node:rowQueue) {
                row.add(node.val);
            }
            result.add(row);
            Queue<TreeNode> temp = new LinkedList<>();
            while(!rowQueue.isEmpty()) {
                TreeNode tempNode = rowQueue.poll();
                if(tempNode.left != null) {
                    temp.add(tempNode.left);
                }
                if(tempNode.right != null) {
                    temp.add(tempNode.right);
                }
            }
            rowQueue = temp;
        }
        return result;
    }
}
