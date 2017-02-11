/**
 * 
 */
package com.javapractice.lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/binary-tree-serialization/
 * Design an algorithm and write code to serialize and deserialize a binary tree.
 * Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
 * There is no limit of how you deserialize or serialize a binary tree, 
 * you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * Our data serialization use bfs traversal.
 * This is just for when you got wrong answer and want to debug the input.
 * You can use other method to do serializaiton and deserialization.
 *
 */
public class BinaryTreeSerialization {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
		if(root == null) {
			return "#";
		}
		StringBuilder str = new StringBuilder();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			if(queue.peek() == null) {
				str.append("#");
				queue.remove();
			} else {
				str.append(queue.peek().val);
				queue.add(queue.peek().left);
				queue.add(queue.poll().right);
			}
			str.append(",");
		}
		str.deleteCharAt(str.length()-1);
		return str.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
		int len = data.length();
		Queue<String> queue = new LinkedList<>();
		for(int i=0; i<len; i++) {
			int j=i;
			while(j<len && data.charAt(j)!=',') {
				j++;
			}
			queue.add(data.substring(i, j));
			i=j;
		}
		Queue<TreeNode> tree = new LinkedList<>();
		TreeNode res = new TreeNode(0);
		while(!queue.isEmpty()) {
			if(tree.isEmpty()) {
				String cur = queue.poll();
				if(!cur.equals("#")) {
					TreeNode node = new TreeNode(stringToInt(cur));
					tree.add(node);
					res = node;
				} else {
					res = null;
				}
			} else {
				String left = queue.poll();
				if(!left.equals("#")) {
					TreeNode node = new TreeNode(stringToInt(left));
					tree.peek().left = node;
					tree.add(node);
				}
				if(!queue.isEmpty()) {
    				String right = queue.poll();
    				if(!right.equals("#")) {
    					TreeNode node = new TreeNode(stringToInt(right));
    					tree.peek().right = node;
    					tree.add(node);
    				}
				}
				tree.remove();
			}
		}
		return res;
    }
    
	public int stringToInt(String data) {
		int res = 0;
		boolean neg = false;
		for(int i=0; i<data.length(); i++) {
			char cur = data.charAt(i);
			if(cur == '-') {
				neg = true;
			} else {
				res = res*10+cur-48;
			}
		}
		return (neg)?-res:res;
	}
}
