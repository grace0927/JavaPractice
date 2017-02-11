/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/battleships-in-a-board/
 * Given an 2D board, count how many battleships are in it. 
 * The battleships are represented with 'X's, empty slots are represented with '.'s. 
 * You may assume the following rules:
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. 
 * In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column),
 * where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - 
 * there are no adjacent battleships.
 *
 */
public class BattleshipsInABoard {
	public int countBattleships(char[][] board) {
		// corner case check
		if(board.length==0 || board[0].length==0) {
			return 0;
		}
		
		int col=board[0].length, row=board.length;
		int cnt = (board[0][0]=='X') ? 1 : 0;
		
		// loop over first row and count
		for(int i=1; i<col; i++) {
			if(board[0][i]=='X' && board[0][i-1]!='X') {
				cnt++;
			}
		}

		// loop over first col and count
		for(int i=1; i<row; i++) {
			if(board[i][0]=='X' && board[i-1][0]!='X') {
				cnt++;
			}
		}

		// loop over board and count, only valid if its prev col/row is empty
		for(int i=1; i<row; i++) {
			for(int j=1; j<col; j++) {
				if(board[i][j]=='X' && board[i-1][j]!='X' && board[i][j-1]!='X') {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
