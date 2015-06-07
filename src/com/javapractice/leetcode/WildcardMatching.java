/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/wildcard-matching/
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") �� false
 * isMatch("aa","aa") �� true
 * isMatch("aaa","aa") �� false
 * isMatch("aa", "*") �� true
 * isMatch("aa", "a*") �� true
 * isMatch("ab", "?*") �� true
 * isMatch("aab", "c*a*b") �� false
 *
 */
public class WildcardMatching {
	/*
	 * ref: https://leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution
	 */
	public boolean isMatch(String s, String p) {
        int lenS = s.length();
		int lenP = p.length();
		int indexS = 0;
		int indexP = 0;
		int match = 0;
		int indexStar = -1;
		
		while(indexS < lenS) {
			char curS = s.charAt(indexS);
			
			if(indexP<lenP && (p.charAt(indexP)=='?' || p.charAt(indexP)==curS)) {
				indexS++;
				indexP++;
			} else if(indexP<lenP && p.charAt(indexP)=='*') {
				indexStar = indexP;
				match = indexS;
				indexP++;
			} else if(indexStar != -1) {
				indexP = indexStar+1;
				match++;
				indexS = match;
			} else {
				return false;
			}
		}
		
		while(indexP<lenP && p.charAt(indexP)=='*') {
			indexP++;
		}
		
		return (indexP==lenP);
    }
}
