/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/minesweeper/
 * Let's play the minesweeper game (Wikipedia, online game)!
 * You are given a 2D char matrix representing the game board.
 * 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square,
 * 'B' represents a revealed blank square that has no adjacent
 * (above, below, left, right, and all 4 diagonals) mines,
 * digit ('1' to '8') represents how many mines are adjacent to this revealed square,
 * and finally 'X' represents a revealed mine.
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'),
 * return the board after revealing this position according to the following rules:
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B')
 * and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed,
 * then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 * Note:
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'),
 * which also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem.
 * For example, you don't need to reveal all the unrevealed mines when the game is over,
 * consider any cases that you will win the game or flag any squares.
 *
 */
public class Minesweeper {
	public char[][] updateBoard(char[][] board, int[] click) {
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}

		boolean[][] visit = new boolean[board.length][board[0].length];

		updateMine(board, visit, click[0], click[1]);

		return board;
	}

	public void updateMine(char[][] board, boolean[][] visit, int row, int col) {
		if (visit[row][col]) {
			return ;
		}
		visit[row][col] = true;

		int mines = getMines(board, row, col);

		if (mines == 0) {
			board[row][col] = 'B';

			for (int i=-1; i<2; i++) {
				for (int j=-1; j<2; j++) {
					if (row+i>=0 && row+i<board.length && col+j>=0 && col+j<board[0].length) {
						updateMine(board, visit, row+i, col+j);
					}
				}
			}

			return ;
		}

		board[row][col] = (char) ('0'+mines);
	}

	public int getMines(char[][] board, int row, int col) {
		int mines = 0;

		for (int i=-1; i<2; i++) {
			for (int j=-1; j<2; j++) {
				if (row+i>=0 && row+i<board.length && col+j>=0 && col+j<board[0].length) {
					mines += (board[row+i][col+j] == 'M') ? 1 : 0;
				}
			}
		}

		return mines;
	}
}
