/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * https://oj.leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on 
 * an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty 
 * space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *   
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */
public class NQueens {
	public List<String[]> solveNQueens(int n) {
        String[] row = new String[n];
        for(int i=0; i<n; i++) {
            StringBuilder temp = new StringBuilder();
            for(int j=0; j<n; j++) {
                temp.append('.');
            }
            row[i] = temp.toString();
        }
        List<String[]> result = new ArrayList<>();
        solveNQueensUtil(result, row, 0, n);
        return result;
    }
    
    public void solveNQueensUtil(List<String[]> result, String[] row, int index, int n) {
        if(index == n) {
            String[] cur = row.clone();
            result.add(cur);
            return ;
        }
        for(int i=0; i<n; i++) {
            if(isSafe(row, i, index)) {
                row[index] = row[index].substring(0,i)+'Q'+row[index].substring(i+1);
                solveNQueensUtil(result, row, index+1, n);
                row[index] = row[index].substring(0,i)+'.'+row[index].substring(i+1);
            } else {
                continue;
            }
        }
    }
    
    public boolean isSafe(String[] result, int column, int row) {
        for(int i=0; i<row; i++) {
            if(result[i].charAt(column) == 'Q') {
                return false;
            }
            if(column-row+i >= 0 && result[i].charAt(column-row+i) == 'Q') {
                return false;
            }
            if(column+row-i < result.length && result[i].charAt(column+row-i) == 'Q') {
                return false;
            }
        }
        
        return true;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NQueens test = new NQueens();
		test.solveNQueens(1);

	}

}
