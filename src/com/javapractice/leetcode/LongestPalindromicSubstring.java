/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic
 * substring. 
 *
 */
public class LongestPalindromicSubstring {
	/*
	 * ref: http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
	 */
	public String longestPalindrome(String s) {
        int len = s.length();
		if(len <= 1) {
			return s;
		}
        boolean[][] table = new boolean[len][len];
		
		for(int i=0; i<len; i++) {
			table[i][i] = true;
			for(int j=0; j<i; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					if(j < i-2) {
						table[j][i] = table[j+1][i-1];
					} else {
						table[j][i] = true;
					}
				} else {
					table[j][i] = false;
				}
			}
		}
		
		String result = "";
		int max = 1;
		for(int i=0; i<len; i++) {
			for(int j=len-1; j>i; j--) {
				if(table[i][j]) {
					if(max < j-i+1) {
						result = s.substring(i, j+1);
						max = j-i+1;
					}
					break;
				}
			}
		}

		return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestPalindromicSubstring test = new LongestPalindromicSubstring();
		System.out.println(test.longestPalindrome("aaabaaaa"));

	}

}
