/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/next-greater-element-ii/
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 */
public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		int[] map = new int[26];

		for (char c:s.toCharArray()) {
			map[(int)(c-'a')]++;
		}

		for (int i=0; i<s.length(); i++) {
			if (map[(int)(s.charAt(i)-'a')]==1) {
				return i;
			}
		}

		return -1;
	}
}
