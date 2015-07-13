/**
 * 
 */
package com.javapractice.lintcode;

import java.util.Set;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/word-ladder/
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 */
public class WordLadder {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
   public int ladderLength(String start, String end, Set<String> dict) {
       // write your code here
       if(start.equals(end)) {
           return 1;
       }
		int min = 0;
		char[] cur = start.toCharArray();
		if(dict.contains(start)) {
		    dict.remove(start);
		}
		for(int i=0; i<start.length(); i++) {
			for(int j=0; j<26; j++) {
				cur[i] = (char)(97+j);
				String word = new String(cur);
				if(dict.contains(word)) {
					int temp = ladderLength(word, end, dict)+1;
					min = (min==0)?temp:min;
					min = (min>temp)?temp:min;
				}
			}
		}
		dict.add(start);
		return min;
   }
}
