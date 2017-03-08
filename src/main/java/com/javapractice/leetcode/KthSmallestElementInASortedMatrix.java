/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix = [
 *  [ 1,  5,  9],
 *  [10, 11, 13],
 *  [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 * Good Thought using Heap and Binary Search:
 * https://discuss.leetcode.com/topic/52948/share-my-thoughts-and-clean-java-code
 *
 */
public class KthSmallestElementInASortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length;
		int[] array = new int[row*row];

		for (int i=0; i<row*row; i++) {
			array[i] = matrix[i/row][i%row];
		}

		Arrays.sort(array);

		return array[k-1];
	}
}
