/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/diagonal-traverse/
 * Given a matrix of M x N elements (M rows, N columns),
 * return all elements of the matrix in diagonal order as shown in the below image.
 *
 */
public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		if(isEmpty(matrix)) {
			return new int[0];
		}

		int row=matrix.length, col=matrix[0].length, i=0, j=0, k=0, total=row*col;
		int[] result = new int[total];
		result[k++] = matrix[i][j];

		while(k<total) {
			if(j+1<col) {
				j++;
			} else {
				i++;
			}

			for(;i<row && j>=0; i++, j--) {
				result[k++] = matrix[i][j];
			}
			i--;
			j++;

			if(i+1<row) {
				i++;
			} else {
				j++;
			}

			for(;i>=0 && j<col; i--, j++) {
				result[k++] = matrix[i][j];
			}
			i++;
			j--;
		}

		return result;
	}

	public boolean isEmpty(int[][] matrix) {
		return matrix.length==0 || matrix[0].length==0;
	}
}
