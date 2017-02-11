/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/edit-distance/
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Given word1 = "mart" and word2 = "karma", return 3.
 *
 */
public class EditDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int len1 = word1.length();
        int len2 = word2.length();
		int[][] res = new int[len1+1][len2+1];
		
		for(int i=0; i<=len1; i++) {
			res[i][0] = i;
		}
		for(int i=0; i<=len2; i++) {
			res[0][i] = i;
		}
		
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				res[i][j] = (word1.charAt(i-1) == word2.charAt(j-1))?0:1;
				res[i][j] = Math.min(Math.min(res[i-1][j], res[i][j-1])+1, res[i-1][j-1]+res[i][j]);
			}
		}
		
		return res[len1][len2];
    }
}
