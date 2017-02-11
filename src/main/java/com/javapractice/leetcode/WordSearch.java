/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be 
 * used more than once.
 * For example,
 * Given board =
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
        int row = board.length;
		if(row == 0) {
			return word.equals("");
		}
		int col = board[0].length;
		if(col == 0) {
			return word.equals("");
		}
		
		if(word.length() == 0) {
			return true;
		}
		char head = word.charAt(0);
		boolean[][] status = new boolean[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(board[i][j] == head) {
					status[i][j] = true;
					if(existUtil(board, word, i, j, 0, 1, status)) {
						return true;
					}
					status[i][j] = false;
				}
			}
		}
		
		return false;
    }
	
	public boolean existUtil(char[][] board, String word, int row, int col, int side, int len, boolean[][] status) {
		if(word.length() == len) {
			return true;
		}
		for(int i=side; i<4; i++) {
			switch(i) {
				case 0:
					int up = row-1;
					if(up < 0 || status[up][col]) {
						continue;
					}
					if(board[up][col] == word.charAt(len)) {
						status[up][col] = true;
						if(existUtil(board, word, up, col, 0, len+1, status)) {
							return true;
						}
						status[up][col] = false;
					}
					break;
				case 1:
					int right = col+1;
					if(right >= board[0].length || status[row][right]) {
						continue;
					}
					if(board[row][right] == word.charAt(len)) {
						status[row][right] = true;
						if(existUtil(board, word, row, right, 0, len+1, status)) {
							return true;
						}
						status[row][right] = false;
					}
					break;
				case 2:
					int down = row+1;
					if(down >= board.length || status[down][col]) {
						continue;
					}
					if(board[down][col] == word.charAt(len)) {
						status[down][col] = true;
						if(existUtil(board, word, down, col, 0, len+1, status)) {
							return true;
						}
						status[down][col] = false;
					}
					break;
				case 3:
					int left = col-1;
					if(left < 0 || status[row][left]) {
						continue;
					}
					if(board[row][left] == word.charAt(len)) {
						status[row][left] = true;
						if(existUtil(board, word, row, left, 0, len+1, status)) {
							return true;
						}
						status[row][left] = false;
					}
					break;
			}
		}
		return false;
    }
}
