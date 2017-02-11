/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/unique-paths-ii/
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
 * Note: m and n will be at most 100.
 *
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null) {
			return 0;
		}
		
		int row = obstacleGrid.length;
		int column = obstacleGrid[0].length;
		
		if(obstacleGrid[row-1][column-1] == 1) {
			return 0;
		} else {
			obstacleGrid[row-1][column-1] = 1;
		}
		
		for(int i=row-2; i>=0; i--) {
			if(obstacleGrid[i][column-1] != 1) {
				obstacleGrid[i][column-1] = 1;
			} else {
				obstacleGrid[i][column-1] = 0;
				while(i>0) {
					obstacleGrid[--i][column-1] = 0;
				}
			}
		}
		for(int i=column-2; i>=0; i--) {
			if(obstacleGrid[row-1][i] != 1) {
				obstacleGrid[row-1][i] = 1;
			} else {
				obstacleGrid[row-1][i] = 0;
				while(i>0) {
					obstacleGrid[row-1][--i] = 0;
				}
			}
		}
		
		for(int i=row-2; i>=0; i--) {
			for(int j=column-2; j>=0; j--) {
				if(obstacleGrid[i][j] != 1) {
					obstacleGrid[i][j] = obstacleGrid[i+1][j] + obstacleGrid[i][j+1];
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}
		
		return obstacleGrid[0][0];
    }

}
