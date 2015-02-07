/**
 * 
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author feng
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = s.length();
        int max = 0;
        int start = 0;
        
        for(int i=0; i<len; i++) {
            String cur = s.substring(i, i+1);
            if(map != null && map.containsKey(cur) && map.get(cur) >= start) {
                max = Math.max(i-start, max);
                start = map.get(cur) + 1;
            }
            map.put(cur, i);
        }
        max = Math.max(len-start, max);
        
        return max;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(test.lengthOfLongestSubstring("aa"));

	}

}
