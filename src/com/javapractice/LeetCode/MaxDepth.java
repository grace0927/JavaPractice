/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javapractice.LeetCode;

/**
 *
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root != null) {
            depth = 1;
            int deltaLeft = 0;
            int deltaRight = 0;
            if(root.left != null) {
                deltaLeft = maxDepth(root.left);
            }
            if(root.right != null) {
                deltaRight = maxDepth(root.right);
            }
            if(deltaLeft > deltaRight) {
                depth += deltaLeft;
            } else {
                depth += deltaRight;
            }
        }
        
        return depth;
    }
}
