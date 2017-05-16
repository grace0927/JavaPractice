/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jianyu Feng
 * https://oj.leetcode.com/problems/repeated-dna-sequences/
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated
 * sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * ref: http://yuanhsh.iteye.com/blog/2185976
 *
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequencesOld(String s) {
		List<String> list = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int len = s.length();
		Integer[] arr = new Integer[2*len];

		for(int i=0; i<len; i++) {
			char cur = s.charAt(i);
			switch(cur) {
				case 'A':
					arr[2*i] = 0;
					arr[2*i+1] = 0;
					break;
				case 'C':
					arr[2*i] = 0;
					arr[2*i+1] = 1;
					break;
				case 'G':
					arr[2*i] = 1;
					arr[2*i+1] = 0;
					break;
				case 'T':
					arr[2*i] = 1;
					arr[2*i+1] = 1;
					break;
			}
		}

		for(int i=0; i<=len-10; i++) {
			int cur = 0;
			for(int j=19; j>=0; j--) {
				cur = (cur<<1)+arr[2*i+j];
			}
			if(map.containsKey(cur)) {
				if(map.get(cur) == 1) {
					list.add(s.substring(i, i+10));
					map.put(cur, map.get(cur)+1);
				}
			} else {
				map.put(cur, 1);
			}
		}

		return list;
	}

	public List<String> findRepeatedDnaSequences(String s) {
		HashMap<String, Integer> set = new HashMap<>();
		List<String> list = new ArrayList<>();

		for (int i=0; i<=s.length()-10; i++) {
			String sub = s.substring(i, i+10);
			if (set.containsKey(sub) && set.get(sub)==1) {
				list.add(sub);
			}
			set.put(sub, set.getOrDefault(sub, 0)+1);
		}

		return list;
	}
}
