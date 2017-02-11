/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author feng
 * https://oj.leetcode.com/problems/word-ladder/
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 */
public class WordLadder {
	public int ladderLength(String start, String end, Set<String> dict) {
		if(isNeigh(start, end)) {
            return 1;
        }
		if(!dict.contains(start)) {
			dict.add(start);
		}
		if(!dict.contains(end)) {
			dict.add(end);
		}
        Iterator<String> itor = dict.iterator();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        while(itor.hasNext()) {
            String cur = itor.next();
            ArrayList<String> list = new ArrayList<>();
            map.put(cur, list);
            
            Iterator<String> temp = dict.iterator();
            while(temp.hasNext()) {
                String ver = temp.next();
                if(isNeigh(ver, cur)) {
                    map.get(cur).add(ver);
                }
            }
        }
        
        Stack<String> stack = new Stack<>();
        stack.push(start);
        for(int i=1; i<dict.size(); i++) {
            Stack<String> temp = new Stack<>();
            while(!stack.isEmpty()) {
                String cur = stack.pop();
                if(cur.equals(end)) {
                    return i;
                }
                if(!map.containsKey(cur)) {
                    continue;
                }
                for(String neigh:map.get(cur)) {
                    temp.push(neigh);
                }
                map.remove(cur);
            }
            stack = temp;
        }
        
        return 0;
    }
    
    public boolean isNeigh(String a, String b) {
        int count = 0;
        int len = a.length();
        if(b.length()!=len) {
            return false;
        }
        
        for(int i=0; i<len; i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                count++;
            }
        }
        
        return count==1;
    }
    
    /*
     * ref: http://www.programcreek.com/2012/12/leetcode-word-ladder/
     */
    public int ladderLengthFaster(String start, String end, Set<String> dict) {
    	Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Queue<Integer> step = new LinkedList<>();
        step.add(1);
        
       	while(!queue.isEmpty()) {
       		String cur = queue.poll();
       		Integer curStep = step.poll();
       		if(cur.equals(end)) {
        		return curStep;
        	}
        		
        	for(int j=0; j<cur.length(); j++) {
            	char[] arr = cur.toCharArray();
        		for(char c='a';c<='z';c++) {
        			arr[j] = c;
        			String neigh = new String(arr);
        			if(dict.contains(neigh)) {
        				queue.add(neigh);
        				step.add(curStep+1);
       		            dict.remove(neigh);
        			}
        		}
        	}
        }
        
        return 0;
    }
}
