/**
 * 
 */
package leetCode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
    	// special cases
		if(grid == null || grid.length == 0) {
			return 0;
		}
		
		// define parameters
		int row = grid.length;
		int column = grid[0].length;
		
		// initialize result set
		for(int i=row-2; i>=0; i--) {
			grid[i][column-1] += grid[i+1][column-1];
		}
		for(int i=column-2; i>=0; i--) {
			grid[row-1][i] += grid[row-1][i+1];
		}
		
		// calculate result set
		for(int i=row-2; i>=0; i--) {
			for(int j=column-2; j>=0; j--) {
				grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
			}
		}
		
		return grid[0][0];
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
