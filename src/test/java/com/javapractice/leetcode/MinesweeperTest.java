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
	public void testMinesweeper() {
		char[][] originalBoard = new char[][] {{"EEEEE"},{"EEMEE"},{"EEEEE"},{"EEEEE"}};
		int[] click = new int[] {3, 0};
		String[] expected = new String[] {"B1E1B", "B1M1B", "B111B", "BBBBB"};
		Minesweeper test = new Minesweeper();

		char[][] board = test.updateBoard(originalBoard, click);

		for (int i=0; i<expected.length; i++) {
			assertArrayEquals(board[i], expected[i].toCharArray());
		}
	}
}
