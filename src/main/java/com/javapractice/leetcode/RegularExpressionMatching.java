/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/regular-expression-matching/
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") �� false
 * isMatch("aa","aa") �� true
 * isMatch("aaa","aa") �� false
 * isMatch("aa", "a*") �� true
 * isMatch("aa", ".*") �� true
 * isMatch("ab", ".*") �� true
 * isMatch("aab", "c*a*b") �� true
 *
 */
public class RegularExpressionMatching {
	/*
	 * DP, ref: https://oj.leetcode.com/discuss/18970/concise-recursive-
	 * and-dp-solutions-with-full-explanation-in
	 */
	public boolean isMatch(String s, String p) {
        int lenS = s.length();
		int lenP = p.length();
		boolean[][] table = new boolean[lenS+1][lenP+1];
		
		table[0][0] = true;
		for(int i=0; i<lenS; i++) {
			table[i+1][0] = false;
		}
		for(int i=0; i<lenP; i++) {
			table[0][i+1] = (i>0 && table[0][i-1] && p.charAt(i)=='*');
		}
		
		for(int i=0; i<lenS; i++) {
			for(int j=0; j<lenP; j++) {
				char curS = s.charAt(i);
				char curP = p.charAt(j);
				if(curP != '*') {
					table[i+1][j+1] = (table[i][j] && (curS==curP || curP=='.'));
				} else {
					table[i+1][j+1] = ((j>0 && table[i+1][j-1]) || table[i+1][j] 
							|| (j>0 && table[i][j+1] && (p.charAt(j-1)=='.' 
							|| curS == p.charAt(j-1))));
				}
			}
		}
		
		return table[lenS][lenP];
    }

}
