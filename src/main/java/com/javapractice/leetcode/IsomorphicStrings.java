/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author jianyu
 * https://leetcode.com/problems/isomorphic-strings/
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 *
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Boolean> set = new HashMap<>();
		HashMap<Character, Character> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++) {
			Character a = s.charAt(i);
			Character b = t.charAt(i);
			if(map.containsKey(a)) {
				if(b != map.get(a)) {
					return false;
				}
			} else {
				if(set.containsKey(b)) {
					return false;
				}
				map.put(a, b);
				set.put(b, true);
			}
		}
		
		return true;
    }
}
