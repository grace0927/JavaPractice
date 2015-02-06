package com.javapractice.BackTracking;

/* http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/ */

public class KnightsTour {
	
	private static int N = 8;

	/* A utility function to check if i,j are valid indexes for N*N chessboard */
	private boolean isSafe(int x, int y, int sol[][]) {
		if(x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1) {
			return true;
		}
		return false;
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
	
	/* This function solves the Knight Tour problem using Backtracking. This
	function mainly uses solveKTUtil() to solve the problem. It returns false
	if no complete tour is possible, otherwise return true and prints the tour.
	Please note that there may be more than one solutions, this function
	prints one of the feasible solutions.  */
	private boolean solveKT() {
		int sol[][] = new int[N][N];
		
		/* Initialization of solution matrix */
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sol[i][j] = -1;
			}
		}
		
		/* xMove[] and yMove[] define next move of Knight.
	       xMove[] is for next value of x coordinate
	       yMove[] is for next value of y coordinate */
		int iMove[] = {2,1,-1,-2,-2,-1,1,2};
		int jMove[] = {1,2,2,1,-1,-2,-2,-1};
		
		// Since the Knight is initially at the first block
		sol[0][0] = 0;
		
		/* Start from 0,0 and explore all tours using solveKTUtil() */
		if(solveKTUtil(0, 0, 1, sol, iMove, jMove) == false) {
			System.out.println("Solution not found");
			return false;
		} else {
			printSolution(sol);
		}
		
		return true;
	}
	
	/* A recursive utility function to solve Knight Tour problem */
	private boolean solveKTUtil(int x, int y, int movei, 
			int sol[][], int iMove[], int jMove[]) {
		int nextX, nextY;
		if(movei == N*N) {
			return true;
		}
		
		/* Try all next moves from the current coordinate x, y */
		for(int k=0; k<8; k++) {
			nextX = x + iMove[k];
			nextY = y + jMove[k];
			if(isSafe(nextX, nextY, sol)) {
				sol[nextX][nextY] = movei;
				if(solveKTUtil(nextX, nextY, movei+1, sol, iMove, jMove)==true) {
					return true;
				} else {
					sol[nextX][nextY] = -1; //backtracking
				}
			}
		}
		return false;
	}
	
	/* Driver program to test above functions */
	public static void main(String argv[]) {
		KnightsTour test = new KnightsTour();
		test.solveKT();
		
	}
}