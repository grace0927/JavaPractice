/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javapractice.LeetCode;

import java.util.ArrayList;

/**
 *
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class PreorderTravesalBinaryTree {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
        } else if(root.left == null && root.right != null) {
            res.add(root.val);
            res.addAll(preorderTraversal(root.right));
        } else if(root.left != null && root.right == null) {
            res.add(root.val);
            res.addAll(preorderTraversal(root.left));
        } else if(root.left == null && root.right == null) {
            res.add(root.val);
        } else {
            res.add(root.val);
            res.addAll(preorderTraversal(root.left));
            res.addAll(preorderTraversal(root.right));
        }
        return res;
    }
}
