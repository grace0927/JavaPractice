/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 */

public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBSTOld(int[] num) {
		if(num == null) {
			// basic case: null array
			return null;
		} else if(num.length == 0) {
			// basic case: array of size one
			return null;
		} else if(num.length == 1) {
			// basic case: array of size one
			return new TreeNode(num[0]);
		} else if(num.length == 2) {
			// base case: array of size two
			TreeNode one = new TreeNode(num[0]);
			TreeNode two = new TreeNode(num[1]);
			two.left = one;
			return two;
		} else if(num.length == 3) {
			// basic case: array of size three
			TreeNode one = new TreeNode(num[0]);
			TreeNode two = new TreeNode(num[1]);
			TreeNode three = new TreeNode(num[2]);
			two.left = one;
			two.right = three;
			return two;
		} else {
			// general case: divide array into two arrays
			int size = num.length;
			int mid = size/2;
			TreeNode root = new TreeNode(num[mid]);

			int[] left = new int[mid];
			for(int i=0; i<mid; i++) {
				left[i] = num[i];
			}

			int[] right = new int[size-mid-1];

			for(int i=mid+1; i<size; i++) {
				right[i-mid-1] = num[i];
			}

			TreeNode leftChild = sortedArrayToBST(left);
			TreeNode rightChild = sortedArrayToBST(right);
			root.left = leftChild;
			root.right = rightChild;

			return root;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length);
	}

	public TreeNode helper(int[] nums, int start, int end) {
		if (start>=end) {
			return null;
		}

		int mid = start+(end-start)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, start, mid);
		node.right = helper(nums, mid+1, end);

		return node;
	}
}
