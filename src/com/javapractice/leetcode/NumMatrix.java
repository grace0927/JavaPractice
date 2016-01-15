/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle 
 * defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) 
 * and (row2, col2) = (4, 3), which contains sum = 8.
 * Example:
 * Given matrix = [
 *   [3, 0, 1, 4, 2],
 *   [5, 6, 3, 2, 1],
 *   [1, 2, 0, 1, 5],
 *   [4, 1, 0, 1, 7],
 *   [1, 0, 3, 0, 5]
 * ]
 * sumRegion(2, 1, 4, 3) -> 8
 * sumRegion(1, 1, 2, 2) -> 11
 * sumRegion(1, 2, 2, 4) -> 12
 * Note:
 * You may assume that the matrix does not change.
 * There are many calls to sumRegion function.
 * You may assume that row1 ≤ row2 and col1 ≤ col2.
 *
 */
public class NumMatrix {
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if(row <= 0) {
            sums = new int[0][0];
        } else {
            int col = matrix[0].length;
            sums = new int[row][col+1];
            for(int i=0; i<row; i++) {
                sums[i][0] = 0;
                for(int j=1; j<=col; j++) {
                    sums[i][j] = sums[i][j-1]+matrix[i][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<=row2; i++) {
            sum += (sums[i][col2+1] - sums[i][col1]);
        }
        return sum;
    }
    
    /*
     * faster.
     *  
	private int[][] sums;
	
	public NumMatrix(int[][] matrix) {
		int row = matrix.length;
		if(matrix==null || row<=0 || matrix[0].length<=0) {
			return ;
		}
        int col = matrix[0].length;
        sums = new int[row+1][col+1];
        for(int i=0; i<=col; i++) {
            sums[0][i] = 0;
        }
        for(int i=1; i<=row; i++) {
            sums[i][0] = 0;
            for(int j=1; j<=col; j++) {
                sums[i][j] = sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1]-sums[row1][col2+1]-sums[row2+1][col1]+sums[row1][col1];
    }
     * 
     */
}
