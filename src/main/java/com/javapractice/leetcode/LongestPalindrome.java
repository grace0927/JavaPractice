/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/longest-palindrome/
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int[] charMap = buildMap(s);

		return getLongest(charMap);
	}

	public int getLongest(int[] map) {
		int one=0, result=0;

		for (int i=0; i<map.length; i++) {
			if (one!=1 && map[i]%2==1) {
				one = 1;
			}

			result += map[i] - map[i]%2;
		}

		return result+one;
	}

	public int[] buildMap(String s) {
		int[] charMap = new int[52];

		for (char c:s.toCharArray()) {
			if (c>='A' && c<='Z') {
				charMap[c-'A']++;
			} else {
				charMap[26+c-'a']++;
			}
		}

		return charMap;
	}
}
