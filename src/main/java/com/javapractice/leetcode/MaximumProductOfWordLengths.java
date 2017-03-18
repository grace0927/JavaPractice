/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author Feng
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters.
 * If no such two words exist, return 0.
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 *
 */
public class MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
		int len = words.length;

		int[] bits = new int[len];
		for(int i=0; i<len; i++) {
			for(int j=0; j<words[i].length(); j++) {
				bits[i] |= 1<<(words[i].charAt(j)-'a');
			}
		}

		int max = 0;
		for(int i=0; i<len; i++) {
			for(int j=i; j<len; j++) {
				if((bits[i] & bits[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}

		return max;
	}

	public int maxProductHashMap(String[] words) {
		int maxProduct=0;
		HashMap<String, Integer> map = new HashMap<>();

		buildMap(words, map);

		for (String s1:map.keySet()) {
			for (String s2:map.keySet()) {
				if ((map.get(s1)&map.get(s2))==0) {
					maxProduct = Math.max(maxProduct, s1.length() * s2.length());
				}
			}
		}

		return maxProduct;
	}

	public void buildMap(String[]words, HashMap<String, Integer> map) {
		for (int i=0; i<words.length; i++) {
			if (!map.containsKey(words[i])) {
				map.put(words[i], hash(words[i]));
			}
		}
	}

	public int hash(String s) {
		int hashValue = 0;

		for (char c:s.toCharArray()) {
			int value = 1 << (c-'a');
			hashValue |= value;
		}

		return hashValue;
	}
}
