/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 *  where 'Q' and '.' both indicate a queen and an empty space respectively.
 *  There exist two distinct solutions to the 4-queens puzzle:
 *  [
 *      [".Q..", // Solution 1
 *       "...Q",
 *       "Q...",
 *       "..Q."],
 *      ["..Q.", // Solution 2
 *       "Q...",
 *       "...Q",
 *       ".Q.."]
 *  ]
 *  Can you do it without recursion?
 *
 */
public class NQueens {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
		ArrayList<ArrayList<String>> res = new ArrayList<>();
		int[][] board = new int[n][n];
		solveNQueensUtil(res, board, 0);
		return res;
    }
	
	public boolean isValid(int[][] board, int row, int col) {
		int len = board.length;
		for(int i=0; i<len; i++) {
			if(board[row][i]==1 || board[i][col]==1) {
				return false;
			}
			if(col-row+i>=0 && col-row+i<len && board[i][col-row+i]==1) {
			    return false;
			}
			if(col+row-i>=0 && col+row-i<len && board[i][col+row-i]==1) {
			    return false;
			}
		}
		return true;
	}
	
	public void solveNQueensUtil(ArrayList<ArrayList<String>> res, int[][] board, int row) {
		for(int j=0; j<board.length; j++) {
			if(isValid(board, row, j)) {
				board[row][j] = 1;
				if(row==board.length-1) {
					ArrayList<String> arr = new ArrayList<>();
					printBoard(res, arr, board);
				} else {
					solveNQueensUtil(res, board, row+1);
				}
				board[row][j] = 0;
			}
		}
	}
	
	public void printBoard(ArrayList<ArrayList<String>> res, ArrayList<String> arr, int[][] board) {
		for(int i=0; i<board.length; i++) {
			String row = new String();
			for(int j=0; j<board.length; j++) {
				if(board[i][j] == 1) {
					row += "Q";
				} else {
					row += ".";
				}
			}
			arr.add(row);
		}
		res.add(arr);
    }
}
