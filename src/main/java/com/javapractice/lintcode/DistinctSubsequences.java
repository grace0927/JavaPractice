/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/distinct-subsequences/
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Given S = "rabbbit", T = "rabbit", return 3.
 * Do it in O(n2) time and O(n) memory.
 * O(n2) memory is also acceptable if you do not know how to optimize memory.
 *
 */
public class DistinctSubsequences {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
		int lenS = S.length();
		int lenT = T.length();
		int[] res = new int[lenS+1];
		
		for(int i=0; i<=lenS; i++) {
			res[i] = 1;
		}
		
		for(int i=1; i<=lenT; i++) {
			int last = res[0];
			res[0] = 0;
			for(int j=1; j<=lenS; j++) {
				int temp = res[j];
				res[j] = res[j-1];
				res[j] += (S.charAt(j-1) == T.charAt(i-1))?last:0;
				last = temp;
			}
		}
		
		return res[lenS];
    }
}
