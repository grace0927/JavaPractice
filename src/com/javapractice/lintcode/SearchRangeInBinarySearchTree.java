/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/
 * Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. 
 * Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST.
 * Return all the keys in ascending order.
 * If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].
 *     20
 *    /  \
 *   8   22
 *  / \
 * 4   12
 *
 */
public class SearchRangeInBinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
		ArrayList<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		
		if(root.left != null) {
			res.addAll(searchRange(root.left, k1, k2));
		}
		
		if(root.val>=k1 && root.val<=k2) {
			res.add(root.val);
		}
		
		if(root.right != null) {
			res.addAll(searchRange(root.right, k1, k2));
		}
		
		return res;
    }
}
