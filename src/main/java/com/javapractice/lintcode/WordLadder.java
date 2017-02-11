/**
 * 
 */
package com.javapractice.lintcode;

import java.util.LinkedList;
import java.util.Queue;
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
	   Queue<String> strQueue = new LinkedList<>();
	   Queue<Integer> cntQueue = new LinkedList<>();
	   
	   strQueue.add(start);
	   cntQueue.add(1);
	   if(dict.contains(start)) {
		   dict.remove(start);
	   }
	   
	   while(!strQueue.isEmpty()) {
		   String str = strQueue.poll();
		   int cnt = cntQueue.poll();
		   if(str.equals(end)) {
			   return cnt;
		   }
		   
		   char[] arr = str.toCharArray();
		   for(int i=0; i<arr.length; i++) {
			   for(char j='a'; j<='z'; j++) {
				   char temp = arr[i];
				   arr[i] = j;
				   String cur = new String(arr);
				   if(dict.contains(cur)) {
					   strQueue.add(cur);
					   cntQueue.add(cnt+1);
					   dict.remove(cur);
				   }
				   arr[i] = temp;
			   }
		   }
	   }
	   
	   return 0;
    }
}
