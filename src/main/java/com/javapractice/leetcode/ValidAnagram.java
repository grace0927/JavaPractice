/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/valid-anagram/
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * You may assume the string contains only lowercase alphabets.
 *
 */
public class ValidAnagram {
	public boolean isAnagramOld(String s, String t) {
		int[] cnt = new int[26];

		for(int i=0; i<s.length(); i++) {
			cnt[s.charAt(i)-'a']++;
		}

		for(int i=0; i<t.length(); i++) {
			cnt[t.charAt(i)-'a']--;
		}

		for(int i=0; i<26; i++) {
			if(cnt[i]!=0) {
				return false;
			}
		}

		return true;
	}

	public boolean isAnagram(String s, String t) {
		int[] charMap = new int[26];

		addMap(s, charMap);

		subMap(t, charMap);

		for (int i=0; i<26; i++) {
			if (charMap[i]!=0) {
				return false;
			}
		}

		return true;
	}

	public void addMap(String s, int[] map) {
		for (char c:s.toCharArray()) {
			map[c-'a']++;
		}
	}

	public void subMap(String s, int[] map) {
		for (char c:s.toCharArray()) {
			map[c-'a']--;
		}
	}
}
