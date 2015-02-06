/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/n-queens-ii/
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 */
public class NQueensII {
	public int totalNQueens(int n) {
        int[][] row = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                row[i][j] = 0;
            }
        }
        
        return solveNQueensUtil(row, 0, n);
    }
    
    public int solveNQueensUtil(int[][] row, int index, int n) {
        if(index == n) {
            return 1;
        }
        int result = 0;
        for(int i=0; i<n; i++) {
            if(isSafe(row, i, index)) {
                row[index][i] = 1;
                result += solveNQueensUtil(row, index+1, n);
                row[index][i] = 0;
            } else {
                continue;
            }
        }
        return result;
    }
    
    public boolean isSafe(int[][] result, int column, int row) {
        for(int i=0; i<row; i++) {
            if(result[i][column] == 1) {
                return false;
            }
            if(column-row+i >= 0 && result[i][column-row+i] == 1) {
                return false;
            }
            if(column+row-i < result.length && result[i][column+row-i] == 1) {
                return false;
            }
        }
        
        return true;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
