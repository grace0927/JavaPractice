/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
        HashMap<Integer, Queue<Character>> map = new HashMap<>();
		for(int i=0; i<nRows; i++) {
			map.put(i, new LinkedList<Character>());
		}
		
		int index = 1;
		boolean even = false;
		for(int i=0; i<s.length(); i++) {
			char cur = s.charAt(i);
			if(index <= 1) {
				index = 1;
				even = false;
			}
			if(even) {
				map.get(index-1).add(cur);
				index--;
				if(index == 1) {
					even = false;
				}
			} else {
				map.get(index-1).add(cur);
				index++;
				if(index > nRows) {
					even = true;
					index -= 2;
				}
			}
		}
		
		StringBuilder result = new StringBuilder();
		for(int i=0; i<nRows; i++) {
			Queue<Character> cur = map.get(i);
			while(!cur.isEmpty()) {
				result.append(cur.poll());
			}
		}
		
		return result.toString();
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
