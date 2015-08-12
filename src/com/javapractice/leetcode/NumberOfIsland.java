/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/number-of-islands/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 *
 */
public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        int island = 0;
        for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					grid[i][j] = '0';
					island++;
					flip(grid, i, j);
				}
			}
		}
		return island;
    }
	
	public void flip(char[][] grid, int row, int col) {
		// upside
		if(row-1>=0 && grid[row-1][col] == '1') {
			grid[row-1][col] = '0';
			flip(grid, row-1, col);
		}
		// down
		if(row+1<grid.length && grid[row+1][col] == '1') {
			grid[row+1][col] = '0';
			flip(grid, row+1, col);
		}
		// left
		if(col-1>=0 && grid[row][col-1] == '1') {
			grid[row][col-1] = '0';
			flip(grid, row, col-1);
		}
		// right
		if(col+1<grid[0].length && grid[row][col+1] == '1') {
			grid[row][col+1] = '0';
			flip(grid, row, col+1);
		}
    }
}
