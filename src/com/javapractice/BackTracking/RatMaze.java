package com.javapractice.BackTracking;

/*http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/*/

public class RatMaze {
	
	private static int N = 4;

	/* A utility function to print solution matrix sol[N][N] */
	private void printSolution(int sol[][]) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.println(sol[i][j]);
			}
			System.out.println("\n");
		}
	}
	
	/* A utility function to check if x,y is valid index for N*N maze */
	private boolean isSafe(int maze[][], int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N && maze[x][y]==1) {
			return true;
		}
		return false;
	}
	
	/* This function solves the Maze problem using Backtracking.  It mainly uses
	solveMazeUtil() to solve the problem. It returns false if no path is possible,
	otherwise return true and prints the path in the form of 1s. Please note that
	there may be more than one solutions, this function prints one of the feasible
	solutions.*/
	private boolean solveMaze(int maze[][]) {
		int[][] sol = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		if(solveMazeUtil(maze, 0, 0, sol)==false) {
			System.out.println("Solution no found");
			return false;
		}
		
		printSolution(sol);
		return true;
		
	}
	
	/* A recursive utility function to solve Maze problem */
	private boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
		// if (x,y is goal) return true
		if(x==N-1 && y==N-1) {
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze, x, y)==true) {
			// mark x,y as part of solution path
			sol[x][y] = 1;
			
			/* Move forward in x direction */
			if(solveMazeUtil(maze, x+1, y, sol)==true) {
				return true;
			}
			
			/* If moving in x direction doesn't give solution then
	           Move down in y direction  */
			if(solveMazeUtil(maze, x, y+1, sol)==true) {
				return true;
			}
			
			/* If none of the above movements work then BACKTRACK: 
            unmark x,y as part of solution path */
			sol[x][y] = 0;
			return false;
		}
		
		return false;
	}
	
	// driver program to test above function
	public static void main(String[] args) {
		int[][] maze = {
				{1, 0, 0, 0},
				{1, 1, 0, 1},
				{0, 1, 0, 1},
				{1, 1, 1, 1}
		};
		
		RatMaze test = new RatMaze();
		test.solveMaze(maze);
		

	}

}
