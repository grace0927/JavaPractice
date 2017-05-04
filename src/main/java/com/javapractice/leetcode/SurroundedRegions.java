/**
 *
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/surrounded-regions/
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * ref: http://blog.csdn.net/linhuanmars/article/details/22904855
 *
 */
public class SurroundedRegions {
	public void solveOld(char[][] board) {
		if(board==null || board.length<=1 || board[0].length<=1) {
			return ;
		}

		int row = board.length;
		int col = board[0].length;

		for(int i=0; i<row; i++) {
			solveUtil(board, i, 0);
			solveUtil(board, i, col-1);
		}
		for(int i=0; i<col; i++) {
			solveUtil(board, 0, i);
			solveUtil(board, row-1, i);
		}

		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(board[i][j]=='O') {
					board[i][j] = 'X';
				} else if(board[i][j]=='#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	/*
	 * Iterative BFS
	 */
	public void solveUtil(char[][] board, int rowIdx, int colIdx) {
		if(board[rowIdx][colIdx] != 'O') {
			return ;
		}

		board[rowIdx][colIdx] = '#';
		Queue<Integer> queue = new LinkedList<>();
		int cur = rowIdx*board[0].length+colIdx;
		queue.add(cur);
		while(!queue.isEmpty()) {
			cur = queue.poll();

			int row = cur/board[0].length;
			int col = cur%board[0].length;

			if(row>0 && board[row-1][col]=='O') {
				board[row-1][col] = '#';
				queue.add(cur-board[0].length);
			}
			if(row<board.length-1 && board[row+1][col]=='O') {
				board[row+1][col] = '#';
				queue.add(cur+board[0].length);
			}
			if(col>0 && board[row][col-1]=='O') {
				board[row][col-1] = '#';
				queue.add(cur-1);
			}
			if(col<board[0].length-1 && board[row][col+1]=='O') {
				board[row][col+1] = '#';
				queue.add(cur+1);
			}
		}
	}

	public void solve(char[][] board) {
		if (board.length<2 || board[0].length<2) {
			return ;
		}

		reserve(board);
		flip(board);
	}

	private void reserve(char[][] board) {
		for (int i=0; i<board[0].length; i++) {
			reserve(board, 0, i);
			reserve(board, board.length-1, i);
		}

		for (int i=0; i<board.length; i++) {
			reserve(board, i, 0);
			reserve(board, i, board[0].length-1);
		}
	}

	private void reserve(char[][] board, int row, int col) {
		if (row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!='O') {
			return ;
		}

		Stack<int[]> stack = new Stack<>();
		stack.push(new int[]{row, col});
		while (!stack.isEmpty()) {
			int[] coordinate = stack.pop();
			row = coordinate[0];
			col = coordinate[1];
			if (row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!='O') {
				continue;
			}
			board[row][col] = '|';
			stack.push(new int[]{row-1, col});
			stack.push(new int[]{row+1, col});
			stack.push(new int[]{row, col-1});
			stack.push(new int[]{row, col+1});
		}
	}

	private void flip(char[][] board) {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				flip(board, i, j);
			}
		}
	}

	private void flip(char[][] board, int row, int col) {
		if (board[row][col]=='|') {
			board[row][col] = 'O';
			return ;
		}

		board[row][col] = 'X';
	}
}
