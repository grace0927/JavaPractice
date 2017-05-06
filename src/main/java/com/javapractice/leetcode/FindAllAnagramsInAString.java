/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and
 * p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 */
public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		int[] charMap = buildCharMap(p);
		List<Integer> list = new ArrayList<>();
		int limit = s.length()-p.length();

		for (int i=0; i<=limit; i++) {
			if (isAnagram(s.substring(i, i+p.length()), Arrays.copyOf(charMap, 26))) {
				list.add(i);
			}
		}

		return list;
	}

	public int[] buildCharMap(String s) {
		int[] map = new int[26];

		for (char c:s.toCharArray()) {
			map[c-'a']++;
		}

		return map;
	}

	public boolean isAnagram(String s, int[] map) {
		for (char c:s.toCharArray()) {
			if (map[c-'a']<=0) {
				return false;
			}
			map[c-'a']--;
		}

		return true;
	}
}
