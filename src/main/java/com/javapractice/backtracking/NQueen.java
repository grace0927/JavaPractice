package com.javapractice.backtracking;

public class NQueen {

	private static int N = 4;
	
	/* A utility function to check if a queen can be placed on board[row][col]
	   Note that this function is called when "col" queens are already placeed
	   in columns from 0 to col -1. So we need to check only left side for
	   attacking queens */
	private boolean isSafe(int x, int y, int[][] sol) {
		for(int i=0; i<y; i++) {
			if(sol[x][i] == 1) {
				return false;
			}
		}
		
		for(int i=x, j=y; i>=0 && j>=0; i--, j--) {
			if(sol[i][j] == 1) {
				return false;
			}
		}
		
		for(int i=x, j=y; i<N && j>=0; i++, j--) {
			if(sol[i][j] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	/* A utility function to print solution matrix sol[N][N] */
	private void printSolution(int sol[][]) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.println(sol[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	/* A recursive utility function to solve N Queen problem */
	private boolean solveNQUtil(int[][] sol, int y) {
		if(y>=N) {
			return true;
		}
		
		for(int i=0; i<N; i++) {
			if(isSafe(i, y, sol) == true) {
				sol[i][y] = 1;
				if(solveNQUtil(sol, y+1)) {
					return true;
				}
				sol[i][y] = 0;
			}
		}
		
		return false;
	}
	
	private boolean solveNQ() {
		int[][]	 board = { {0, 0, 0, 0},
		        {0, 0, 0, 0},
		        {0, 0, 0, 0},
		        {0, 0, 0, 0}
		    };
		if(solveNQUtil(board, 0)==false) {
			System.out.println("Solution no found");
			return false;
		}
		
		printSolution(board);
		return true;
	}
	
	public static void main(String[] args) {
		NQueen test = new NQueen();
		test.solveNQ();

	}

}
