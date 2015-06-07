/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/edit-distance/
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
        int row = word1.length();
        int column = word2.length();
        if(row == 0 || column == 0) {
            return row==0?column:row;
        }
        
        int[][] ret = new int[row+1][column+1];
        for(int i=0; i<row+1; i++) {
            ret[i][0] = i;
        }
        for(int i=1; i<column+1; i++) {
            ret[0][i] = i;
        }
        
        for(int i=1; i<row+1; i++) {
            for(int j=1; j<column+1; j++) {
                int step = (word1.charAt(i-1) == word2.charAt(j-1))?0:1;
                ret[i][j] = Math.min(Math.min(ret[i-1][j]+1, ret[i][j-1]+1), ret[i-1][j-1]+step);
            }
        }
        
        return ret[row][column];
    }
	
}
