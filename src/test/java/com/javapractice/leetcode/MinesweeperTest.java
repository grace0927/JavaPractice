/**
 *
 */
package com.javapractice.leetcode;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Jianyu Feng
 *
 */
public class MinesweeperTest {
	@Test
	public void testUpdateBoard() {
		char[][] originalBoard = getTestBoard();
		int[] click = new int[] {3, 0};
		String[] expected = new String[] {"B1E1B", "B1M1B", "B111B", "BBBBB"};
		Minesweeper test = new Minesweeper();

		char[][] board = test.updateBoard(originalBoard, click);

		for (int i=0; i<expected.length; i++) {
			assertArrayEquals(board[i], expected[i].toCharArray());
		}
	}
	
	private char[][] getTestBoard() {
		String[] stringBoard = new String[] {"EEEEE", "EEMEE", "EEEEE", "EEEEE"};
		char[][] board = new char[4][5];

		for(int i=0; i<stringBoard.length; i++) {
			board[i] = stringBoard[i].toCharArray();
		}

		return board;
	}
}
