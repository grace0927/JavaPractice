/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jianyu
 * https://leetcode.com/problems/word-ladder-ii/
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 * Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 */
public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
		Queue<List<String>> queueList = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		Queue<Integer> level = new LinkedList<>();
		List<String> neighList = new ArrayList<>();
		int lastLevel = 0;
		
		queue.add(start);
		level.add(0);
		List<String> list = new ArrayList<>();
		list.add(start);
		queueList.add(list);
		
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			List<String> curList = queueList.poll();
			Integer curLevel = level.poll();

			if(curLevel > lastLevel) {
				lastLevel = curLevel;
				for(String str:neighList) {
					if(dict.contains(str)) {
						dict.remove(str);
					}
				}
				neighList.clear();
			}
			
			if(isNeighbor(cur, end)) {
				curList.add(end);
				res.add(curList);
				lastLevel = curLevel;
				break;
			}
			
			for(int i=0; i<cur.length(); i++) {
				char[] arr = cur.toCharArray();
				for(char j='a'; j<='z'; j++) {
					arr[i] = j;
					String neigh = new String(arr);
					if(dict.contains(neigh)) {
						queue.add(neigh);
						level.add(curLevel+1);
						List<String> newList = new ArrayList<>(curList);
						newList.add(neigh);
						neighList.add(neigh);
						queueList.add(newList);
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			List<String> curList = queueList.poll();
			Integer curLevel = level.poll();
			
			if(curLevel==lastLevel && isNeighbor(cur, end)) {
				curList.add(end);
				res.add(curList);
			}
		}
		
		return res;
    }
	
	public boolean isNeighbor(String one, String two) {
		int len = one.length();
		int count = 0;
		
		for(int i=0; i<len; i++) {
			if(one.charAt(i) != two.charAt(i)) {
				count++;
			}
			if(count > 1) {
				return false;
			}
		}
		
		return count==1;
	}

}
