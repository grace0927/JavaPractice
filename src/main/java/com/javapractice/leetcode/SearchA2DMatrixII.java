/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * Consider the following matrix:
 * [
 *  [1,   4,  7, 11, 15],
 *  [2,   5,  8, 12, 19],
 *  [3,   6,  9, 16, 22],
 *  [10, 13, 14, 17, 24],
 *  [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 */
public class SearchA2DMatrixII {
	public boolean searchMatrixOld(int[][] matrix, int target) {
		int row = matrix.length;
		if(row==0) {
			return false;
		}
		int col = matrix[0].length;
		for(int i=0; i<row && matrix[i][0]<=target; i++) {
			if(matrix[i][0]==target || matrix[i][col-1]==target) {
				return true;
			}
			if(matrix[i][col-1]<target) {
				continue;
			}
			// do binary search on column
			int start = 0;
			int end = col-1;
			while(start < end-1) {
				int mid = start + (end-start)/2;
				if(matrix[i][mid] == target) {
					return true;
				} else if(matrix[i][mid] > target) {
					end = mid;
				} else {
					start = mid;
				}
			}
		}
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		for (int i=0; i<matrix.length && matrix[i].length>0 && matrix[i][0]<=target; i++) {
			if (Arrays.binarySearch(matrix[i], target) >= 0) {
				return true;
			}
		}

		return false;
	}
}
