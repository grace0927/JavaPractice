/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * 
 * https://oj.leetcode.com/problems/unique-paths/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach 
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 *
 */
public class UniquePaths {

	/*
	 * recursive with memorization
	 */
    public int[][] res = new int[101][101];
    
    public void init() {
    	for(int i=0;i<101;i++) {
    		for(int j=0;j<101;j++) {
    			res[i][j] = -1;
    		}
    	}
    }
    
    public int uniquePathsUtil(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        } else if(m == 1 && n == 1) {
            return 1;
        }
        
        if(res[m-1][n] == -1) {
            res[m-1][n] = uniquePathsUtil(m-1, n);
        }
        if(res[m][n-1] == -1) {
            res[m][n-1] = uniquePathsUtil(m, n-1);
        }
        
        res[m][n] = res[m-1][n] + res[m][n-1];
        
        return res[m][n];
    }
    
    public int uniquePaths(int m, int n) {
    	init();
    	return uniquePathsUtil(m, n);
    }
    
    // using dynamic programming
    public int uniquePathsDP(int m, int n) {
    	if(m == 0 || n == 0) {
            return 0;
        } else if(m == 1 && n == 1) {
            return 1;
        }
    	
    	int[][] result = new int[m][n];
    	
    	for(int i=0; i<n; i++) {
    		result[m-1][i] = 1;
    	}
    	for(int i=0; i<m; i++) {
    		result[i][n-1] = 1;
    	}
    	
    	for(int i=m-2; i>=0; i--) {
    		for(int j=n-2; j>=0; j--) {
    			result[i][j] = result[i+1][j] + result[i][j+1];
    		}
    	}
    	
    	return result[0][0];
    }

}
