/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/maximal-square/
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 *
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row < 1) {
            return 0;
        }
        int col = matrix[0].length;
        
        int[][] rLength = new int[row][col];
        int[][] cLength = new int[row][col];
        for(int i=0; i<row; i++) {
            cLength[i][0] = (matrix[i][0]=='0')?0:1;
            for(int j=1; j<col; j++) {
                cLength[i][j] = (matrix[i][j]=='0')?0:cLength[i][j-1]+1;
            }
        }
        for(int i=0; i<col; i++) {
            rLength[0][i] = (matrix[0][i]=='0')?0:1;
            for(int j=1; j<row; j++) {
                rLength[j][i] = (matrix[j][i]=='0')?0:rLength[j-1][i]+1;
            }
        }
        
        int[][] area = new int[row][col];
        for(int i=0; i<row; i++) {
            area[i][0] = (matrix[i][0]=='0')?0:1;
        }
        for(int i=0; i<col; i++) {
            area[0][i] = (matrix[0][i]=='0')?0:1;
        }
        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                if(matrix[i][j] == '0') {
                    area[i][j] = 0;
                } else if(matrix[i-1][j-1] == '0') {
                    area[i][j] = 1;
                } else {
                    int len = Math.min(Math.min(rLength[i][j], cLength[i][j]), (int)Math.sqrt(area[i-1][j-1])+1);
                    area[i][j] = len*len;
                }
            }
        }
        
        int max = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                max = Math.max(area[i][j], max);
            }
        }
        
        return max;
    }
}
