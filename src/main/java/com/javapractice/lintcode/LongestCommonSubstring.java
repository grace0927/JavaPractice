/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/longest-common-substring/
 * Given two strings, find the longest common substring.
 * Return the length of it.
 * Have you met this question in a real interview? Yes
 * Example
 * Given A = "ABCD", B = "CBCE", return 2.
 * Note
 * The characters in substring should occur continuously in original string. This is different with subsequence.
 * Challenge
 * O(n x m) time and memory.
 *
 */
public class LongestCommonSubstring {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int lenA = A.length();
        int lenB = B.length();
        if(lenA == 0 || lenB == 0) {
            return 0;
        }
        int[][] ret = new int[lenA+1][lenB+1];

        for(int i=0; i<=lenA; i++) {
        	ret[i][0] = 0;
        }
        for(int j=0; j<=lenB; j++) {
        	ret[0][j] = 0;
        }

        for(int i=1; i<=lenA; i++) {
        	for(int j=1; j<=lenB; j++) {
        		int len = 0;
        		while(len<j && len<i && A.charAt(i-len-1) == B.charAt(j-len-1)) {
        			len++;
        		}
        		ret[i][j] = (ret[i][j-1]>ret[i-1][j])?ret[i][j-1]:ret[i-1][j];
        		ret[i][j] = (ret[i][j]>len)?ret[i][j]:len;
        	}
        }

        return ret[lenA][lenB];
    }
}
