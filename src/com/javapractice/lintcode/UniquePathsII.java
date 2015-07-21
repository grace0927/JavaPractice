/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/unique-paths-ii/
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * m and n will be at most 100.
 *
 */
public class UniquePathsII {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		
		int[][] res = new int[row][col];
		
		boolean block = false;
		for(int i=row-1; i>=0; i--) {
			if(block || obstacleGrid[i][col-1] == 1) {
				res[i][col-1] = 0;
				block = true;
			} else {
				res[i][col-1] = 1;
			}
		}
		block = false;
		for(int i=col-1; i>=0; i--) {
			if(block || obstacleGrid[row-1][i] == 1) {
				res[row-1][i] = 0;
				block = true;
			} else {
				res[row-1][i] = 1;
			}
		}
		
		for(int i=row-2; i>=0; i--) {
			for(int j=col-2; j>=0; j--) {
				if(obstacleGrid[i][j] == 1) {
					res[i][j] = 0;
				} else {
					res[i][j] = res[i+1][j] + res[i][j+1];
				}
			}
		}
		
		return res[0][0];
    }
}
