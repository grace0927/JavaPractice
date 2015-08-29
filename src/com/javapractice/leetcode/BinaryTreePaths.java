/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * https://leetcode.com/problems/binary-tree-paths/
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 *
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        
        if(root!=null) {
            str.append(""+root.val);
            if(root.left==null && root.right==null) {
                list.add(str.toString());
            } else {
                if(root.left!=null) {
                    binaryTreePathsUtil(root.left, str, list);
                }
                if(root.right!=null) {
                    binaryTreePathsUtil(root.right, str, list);
                }
            }
        }
        
        return list;
    }
    
    public void binaryTreePathsUtil(TreeNode root, StringBuilder str, List<String> list) {
        if(root.left==null && root.right==null) {
            int len = str.length();
            str.append("->"+root.val);
            list.add(str.toString());
            str.delete(len, str.length());
        } else {
            int len = str.length();
            str.append("->"+root.val);
            if(root.left!=null) {
                binaryTreePathsUtil(root.left, str, list);
            }
            if(root.right!=null) {
                binaryTreePathsUtil(root.right, str, list);
            }
            str.delete(len, str.length());
        }
    }
}
