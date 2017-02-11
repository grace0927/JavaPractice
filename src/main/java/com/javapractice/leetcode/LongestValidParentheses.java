/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/longest-valid-parentheses/
 * Given a string containing just the characters '(' and ')', find the 
 * length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", 
 * which has length = 4.
 *
 */
public class LongestValidParentheses {
	/*
	 * use DP
	 * ref: http://bangbingsyb.blogspot.com/2014/11/leetcode-longest-valid-parentheses.html
	 * ref: https://leetcodenotes.wordpress.com/2013/10/19/leetcode-longest-valid-parentheses-
	 * %E8%BF%99%E7%A7%8D%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%EF%BC%8C%E6%9C%80%E9%95%BF%E7%9A
	 * %84valid%E6%8B%AC%E5%8F%B7%E7%BB%84%E5%90%88%E6%9C%89%E5%A4%9A/
	 */
	public int longestValidParentheses(String s) {
        int len = s.length();
		int max = 0;
		// use array to record the longest valid parentheses ended at s.charAt(i);
		int[] arr = new int[len+1];
		arr[0] = 0;
		
		for(int i=1; i<=len; i++) {
			// find the left position of last incomplete parenthese
			int j = i-2-arr[i-1];
			
			// record when s.charAt(i-1) = ')' and s.charAt(j) = '('
			if(s.charAt(i-1)=='(' || j<0 || s.charAt(j)==')') {
				arr[i] = 0;
			} else {
				arr[i] = arr[i-1]+2+arr[j];
				max = Math.max(max, arr[i]);
			}
		}
		
		return max;
    }

}
