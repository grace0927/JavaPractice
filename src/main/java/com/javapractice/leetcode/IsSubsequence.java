/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/is-subsequence/
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string
 * which is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * Return true.
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * Return false.
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk
 * where k >= 1B, and you want to check one by one to see if T has its subsequence.
 * In this scenario, how would you change your code?
 *
 */
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		for (int i=0; i<s.length(); i++) {
			for (int j=0; j<t.length(); j++) {
				if (s.charAt(i)==t.charAt(j)) {
					return isSubsequence(s.substring(1), t.substring(j+1));
				}
			}
		}

		return s.length()==0 ? true : false;
	}

	public boolean isSubsequenceIteratively(String s, String t) {
		int start = 0;

		for (int i=0; i<s.length(); i++) {
			if (start==t.length()) {
				return false;
			}

			boolean find = false;
			for (int j=start; j<t.length(); j++) {
				if (s.charAt(i)==t.charAt(j)) {
					find = true;
					start = j+1;
					break;
				}
			}

			if (!find) {
				return false;
			}
		}

		return true;
	}
}
