/**
 * 
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
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
	public void solve(char[][] board) {
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

}
