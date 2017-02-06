/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/island-perimeter/
 * You are given a map in form of a two-dimensional integer grid
 * where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 */
public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		if(grid.length==0 || grid[0].length==0) {
			return 0;
		}
		int row=grid.length, col=grid[0].length, perimeter=0;

		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				// find land
				if(grid[i][j]==1) {
					// count its sides
					int side = 4;
					for(int k=-1; k<2; k+=2) {
						if(i+k>=0 && i+k<row && grid[i+k][j]==1) {
							side--;
						}
						if(j+k>=0 && j+k<col && grid[i][j+k]==1) {
							side--;
						}
					}
					perimeter += side;
				}
			}
		}

		return perimeter;
	}

	// use backtracking
	public int count(boolean[][] visit, int[][] grid, int row, int col) {
		int perimeter=0, side=4;
		for(int i=-1; i<2; i+=2) {
			if(row+i>=0 && row+i<grid.length && grid[row+i][col]==1) {
				side--;
				if(!visit[row+i][col]) {
					visit[row+i][col] = true;
					perimeter += count(visit, grid, row+i, col);
				}
			}
			if(col+i>=0 && col+i<grid[0].length && grid[row][col+i]==1) {
				side--;
				if(!visit[row][col+i]) {
					visit[row][col+i] = true;
					perimeter += count(visit, grid, row, col+i);
				}
			}
		}
		return perimeter+side;
	}
}
