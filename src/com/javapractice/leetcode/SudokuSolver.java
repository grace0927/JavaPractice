/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/sudoku-solver/
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 *
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        solveSudokuUtil(board);
   }
	
	public boolean solveSudokuUtil(char[][] board) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(board[i][j] == '.') {
					for(int k=0; k<9; k++) {
						if(isSafe(board, (char)(k+49), i, j)) {
							board[i][j] = (char)(k+49);
							if(solveSudokuUtil(board)) {
								return true;
							}
						}
						board[i][j] = '.';
					}
					if(board[i][j] == '.') {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean isSafe(char[][] board, char cur, int row, int column) {
		System.out.println(row);
		for(int i=0; i<9; i++) {
			if(board[row][i] == cur) {
				return false;
			}
		}
		
		for(int i=0; i<9; i++) {
			if(board[i][column] == cur) {
				return false;
			}
		}
		
		int areaC = column%3;
		int areaR = row%3;
		
		if(areaC == 0) {
			if(areaR == 0) {
				if(board[row+1][column+1] == cur || board[row+1][column+2] == cur || board[row+2][column+1] == cur || board[row+2][column+2] == cur) {
					return false;
				}
			} else if(areaR == 1) {
				if(board[row+1][column+1] == cur || board[row+1][column+2] == cur || board[row-1][column+1] == cur || board[row-1][column+2] == cur) {
					return false;
				}
			} else {
				if(board[row-1][column+1] == cur || board[row-1][column+2] == cur || board[row-2][column+1] == cur || board[row-2][column+2] == cur) {
					return false;
				}
			}
		} else if(areaC == 1) {
			if(areaR == 0) {
				if(board[row+1][column+1] == cur || board[row+1][column-1] == cur || board[row+2][column+1] == cur || board[row+2][column-1] == cur) {
					return false;
				}
			} else if(areaR == 1) {
				if(board[row+1][column+1] == cur || board[row+1][column-1] == cur || board[row-1][column+1] == cur || board[row-1][column-1] == cur) {
					return false;
				}
			} else {
				if(board[row-1][column+1] == cur || board[row-1][column-1] == cur || board[row-2][column+1] == cur || board[row-2][column-1] == cur) {
					return false;
				}
			}
		} else {
			if(areaR == 0) {
				if(board[row+1][column-1] == cur || board[row+1][column-2] == cur || board[row+2][column-1] == cur || board[row+2][column-2] == cur) {
					return false;
				}
			} else if(areaR == 1) {
				if(board[row+1][column-1] == cur || board[row+1][column-2] == cur || board[row-1][column-1] == cur || board[row-1][column-2] == cur) {
					return false;
				}
			} else {
				if(board[row-1][column-1] == cur || board[row-1][column-2] == cur || board[row-2][column-1] == cur || board[row-2][column-2] == cur) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SudokuSolver test = new SudokuSolver();
		char[][] board = {"..9748...".toCharArray(),"7........".toCharArray(),".2.1.9...".toCharArray(),"..7...24.".toCharArray(),
				".64.1.59.".toCharArray(),".98...3..".toCharArray(),"...8.3.2.".toCharArray(),"........6".toCharArray(),"...2759..".toCharArray()};
		test.solveSudoku(board);

	}

}
