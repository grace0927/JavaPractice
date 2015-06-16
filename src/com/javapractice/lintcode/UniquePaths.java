/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author feng
 * http://www.lintcode.com/en/problem/unique-paths/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * m and n will be at most 100.
 *
 */
public class UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] ret = new int[m][n];
        for(int i=0; i<m; i++) {
            ret[i][0] = 1;
        }
        for(int j=0; j<n; j++) {
            ret[0][j] = 1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                ret[i][j] = ret[i-1][j] + ret[i][j-1];
            }
        }
        
        return ret[m-1][n-1];
    }
}
