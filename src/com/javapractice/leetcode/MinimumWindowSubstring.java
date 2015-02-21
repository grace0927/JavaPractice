/**
 * 
 */
package com.javapractice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author feng
 * https://oj.leetcode.com/problems/minimum-window-substring/
 * Given a string S and a string T, find the minimum window in 
 * S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */
public class MinimumWindowSubstring {
	public String minWindowMine(String S, String T) {
        HashMap<Character, Queue<Integer>> map = new HashMap<>();
        int lenS = S.length();
        if(lenS == 0) {
            return "";
        }
        for(int i=0; i<lenS; i++) {
            char cur = S.charAt(i);
            if(map==null || !map.containsKey(cur)) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                map.put(cur, queue);
            } else {
                map.get(cur).add(i);
            }
        }
        
        int lenT = T.length();
        String res = "";
        int[] arr = new int[lenT];
        for(int i=0; i<lenT; i++) {
            char cur = T.charAt(i);
            if(!map.containsKey(cur) || map.get(cur).isEmpty()) {
                return res;
            }
            arr[i] = map.get(cur).poll();
        }
        Arrays.sort(arr);
        int start = arr[0];
        int end = arr[lenT-1];
        res = S.substring(start, end+1);
        while(!map.get(S.charAt(start)).isEmpty()) {
            arr[0] = map.get(S.charAt(start)).poll();
            Arrays.sort(arr);
            start = arr[0];
            end = arr[lenT-1];
            res = S.substring(start, end+1);
        }
        
        return res;
    }
	
	/*
	 * ref: http://blog.csdn.net/linhuanmars/article/details/20343903
	 */
	public String minWindow(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        int lenT = T.length();
        int lenS = S.length();
        for(int i=0; i<lenT; i++) {
            char cur = T.charAt(i);
            if(map.containsKey(cur)) {
                map.put(cur, map.get(cur)+1);
            } else {
                map.put(cur, 1);
            }
        }
        
        String res = "";
        int total = 0;
        for(int start=0, end=0; end<lenS; end++) {
            char curEnd = S.charAt(end);
            if(map.containsKey(curEnd)) {
                if(map.get(curEnd) > 0) {
                    total++;
                }
                map.put(curEnd, map.get(curEnd)-1);
                while(total == lenT) {
                    if(res.equals("") || res.length() > end-start+1) {
                        res = S.substring(start, end+1);
                    }
                    char curStart = S.charAt(start++);
                    if(map.containsKey(curStart)) {
                        map.put(curStart, map.get(curStart)+1);
                        if(map.get(curStart) > 0) {
                            total--;
                        }
                    }
                }
            }
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
