/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/distinct-subsequences/
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions of 
 * the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * reference: https://oj.leetcode.com/discuss/2143/any-better-solution-that-takes-less-than-space-while-in-time
 * Solution (DP):
 * We keep a m*n matrix and scanning through string S, while
 * m = T.length() + 1 and n = S.length() + 1
 * and each cell in matrix Path[i][j] means the number of distinct subsequences of 
 * T.substr(1...i) in S(1...j)
 * 
 * Path[i][j] = Path[i][j-1]            (discard S[j])
 *              +     Path[i-1][j-1]    (S[j] == T[i] and we are going to use S[j])
 *                 or 0                 (S[j] != T[i] so we could not use S[j])
 * while Path[0][j] = 1 and Path[i][0] = 0.
 *
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
        int lenS = S.length();
		int lenT = T.length();
		int[][] ret = new int[lenT+1][lenS+1];
		
		for(int i=0; i<lenT+1; i++) {
			ret[i][0] = 0;
		}
		for(int i=0; i<lenS+1; i++) {
			ret[0][i] = 1;
		}
		
		for(int i=1; i<lenT+1; i++) {
			for(int j=1; j<lenS+1; j++) {
				ret[i][j] = ret[i][j-1];
				if(S.charAt(j-1) == T.charAt(i-1)) {
					ret[i][j] += ret[i-1][j-1];
				}
			}
		}
		
		return ret[lenT][lenS];
    }
	
	public int numDistinctAlternater(String S, String T) {
        int lenS = S.length();
		int lenT = T.length();
		if(lenT > lenS) {
			return 0;
		}
		int[] ret = new int[lenT+1];
		
		ret[0] = 1;
		for(int i=1; i<lenT+1; i++) {
			ret[i] = 0;
		}
		
		for(int i=1; i<lenS+1; i++) {
			for(int j=lenT; j>=1; j--) {
				if(S.charAt(i-1) == T.charAt(j-1)) {
					ret[j] += ret[j-1];
				}
			}
		}
		
		return ret[lenT];
    }
}
