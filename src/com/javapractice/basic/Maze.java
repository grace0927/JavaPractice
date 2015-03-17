/**
 * 
 */
package com.javapractice.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 *
 */
public class Maze {

	public void solver(boolean[][] board, int start, int end, List<Character> res) {
		if(end == 8) {
			System.out.println(res);
			return ;
		}
		board[start][end] = false;
		board[end][start] = false;
		int next = end-3;
		while(next >= 3) {
			if(board[end][next]) {
				res.add('u');
				solver(board, end, next, res);
				res.remove(res.size()-1);
			}
			next -= 3;
		}
		next = end+3;
		while(next < 9) {
			if(board[end][next]) {
				res.add('d');
				solver(board, end, next, res);
				res.remove(res.size()-1);
			}
			next += 3;
		}
		next = end-1;
		while(next>=0 && next/3 == end/3) {
			if(board[end][next]) {
				res.add('l');
				solver(board, end, next, res);
				res.remove(res.size()-1);
			}
			next--;
		}
		next = end+1;
		while(next<9 && next/3 == end/3) {
			if(board[end][next]) {
				res.add('r');
				solver(board, end, next, res);
				res.remove(res.size()-1);
			}
			next++;
		}
		board[start][end] = true;
		board[end][start] = true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean[][] board = {{false, false, false, false, false, false, true, false, false},
				{false, false, true, false, false, false, false, false, false},
				{false, true, false, false, false, false, false, false, true},
				{true, false, false, false, false, true, true, false, false},
				{false, false, false, true, false, true, false, true, false},
				{false, false, true, true, false, false, false, false, true},
				{true, false, false, false, false, false, false, true, false},
				{false, false, false, false, true, false, true, false, false},
				{false, false, true, false, false, true, false, false, false},
		};
		List<Character> res = new ArrayList<>();
		int next = 0;
		Maze test = new Maze();
		
		next = 3;
		while(next < 9) {
			if(board[0][next]) {
				res.add('d');
				test.solver(board, 0, next, res);
				res.remove(res.size()-1);
			}
			next += 3;
		}
		next = 1;
		while(next/3 == 0/3) {
			if(board[0][next]) {
				res.add('r');
				test.solver(board, 0, next, res);
				res.remove(res.size()-1);
			}
			next++;
		}
		
	}

}
