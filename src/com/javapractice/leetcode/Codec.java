/**
 * 
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Feng
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Serialization is the process of converting a data structure or object 
 * into a sequence of bits so that it can be stored in a file or memory buffer, 
 * or transmitted across a network connection link to be reconstructed later 
 * in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string 
 * and this string can be deserialized to the original tree structure.
 * For example, you may serialize the following tree
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
 * You do not necessarily need to follow this format, so please be creative 
 * and come up with different approaches yourself.
 *
 */
public class Codec implements Solution {
	public void test() {
		TreeNode one = new TreeNode(1);
    	TreeNode two = new TreeNode(2);
    	TreeNode three = new TreeNode(3);
    	TreeNode four = new TreeNode(4);
    	TreeNode five = new TreeNode(5);
    	one.left = two;
    	one.right = three;
    	three.left = four;
    	three.right = five;
    	String res = serialize(one);
    	System.out.println(res);
    	System.out.println(serialize(deserialize(res)));
	}
	
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(tmp == null) {
                sb.append('#');
            } else {
                sb.append(tmp.val);
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
            sb.append(',');
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        
        if(arr[0].equals("#")) {
            return root;
        } else {
            root = new TreeNode(Integer.parseInt(arr[0]));
            queue.add(root);
        }
        
        int idx = 1;
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(!arr[idx].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[idx]));
                tmp.left = left;
                queue.add(left);
            }
            idx++;
            if(!arr[idx].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[idx]));
                tmp.right = right;
                queue.add(right);
            }
            idx++;
        }
        
        return root;
    }
}
