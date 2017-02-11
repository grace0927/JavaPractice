/**
 * 
 */
package com.javapractice.cc150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author feng
 *
 */
public class Chapter112 {
	public class AnagramComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}

		public String sortChars(String s) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			return new String(arr);
		}
	}
	
	public String sortChars(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	public void sort(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		for(String str:strs) {
			String key = sortChars(str);
			if(!map.containsKey(key)) {
				ArrayList<String> list = new ArrayList<>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}

		int idx = 0;
		for(String key:map.keySet()) {
			for(String str:map.get(key)) {
				strs[++idx] = str;
			}
		}
	}
}
