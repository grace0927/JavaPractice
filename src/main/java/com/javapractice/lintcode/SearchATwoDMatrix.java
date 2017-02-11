/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Consider the following matrix:
 * [
 *     [1, 3, 5, 7],
 *     [10, 11, 16, 20],
 *     [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * O(log(n) + log(m)) time
 *
 */
public class SearchATwoDMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) {
        	return false;
        }
        int col = matrix[0].length;

        if(matrix[0][0] > target || target > matrix[row-1][col-1]) {
        	return false;
        }

        int start = 0; 
        int end = row-1;
		while(true) {
			if(target==matrix[start][0] || target==matrix[end][0]) {
				return true;
			}
			if(target>matrix[end][0]) {
			    start = end;
			}
			if(start >= end-1) {
				int cStart = 0;
				int cEnd = col-1;
				if(matrix[start][cEnd]<=target) {
					return (matrix[start][cEnd]==target)?true:false;
				}
				while(cStart < cEnd-1) {
					int mid = cStart + (cEnd-cStart)/2;
					if(target == matrix[start][mid]) {
						return true;
					} else if(target > matrix[start][mid]) {
						cStart = mid;
					} else {
						cEnd = mid;
					}
				}
				return false;
			}
			
			int cur = start+(end-start)/2;
			if(target == matrix[cur][0]) {
				return true;
			} else if(target > matrix[cur][0]) {
				start = cur;
			} else {
				end = cur;
			}
		}
    }
}
