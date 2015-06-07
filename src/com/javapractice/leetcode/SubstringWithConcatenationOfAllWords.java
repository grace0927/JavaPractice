/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly 
 * once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 */
public class SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
        HashMap<String, Integer> map = new HashMap<>();
		int size = L.length;
		if(size == 0) {
			return null;
		}
		int len = L[0].length();
		
		for(int i=0; i<size; i++) {
			if(map.containsKey(L[i])) {
				map.put(L[i], map.get(L[i])+1);
			} else {
				map.put(L[i], 1);
			}
		}
		
		List<Integer> list = new ArrayList<>();
		int lenS = S.length();
		for(int i=0; i<lenS-len*size+1; i++) {
			int start = i;
			HashMap<String, Integer> temp = new HashMap<>(map);
			while(start < lenS-len+1) {
				String cur = S.substring(start, start+len);
				if(temp.containsKey(cur)) {
					int num = temp.get(cur);
					if(num > 1) {
						temp.put(cur, num-1);
					} else {
						temp.remove(cur);
					}
				} else {
					break;
				}
				if(temp.isEmpty()) {
					list.add(i);
					break;
				}
				start+=len;
			}
		}
		
		return list;
    }
}
