/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * https://leetcode.com/problems/text-justification/
 * Given an array of words and a length L, format the text 
 * such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words 
 * as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly
 * L characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will 
 * be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 *
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
        int len = words.length;
		int start = 0;
		List<String> list = new ArrayList<>();
		
		while(start < len) {
			int total = 0;
			int end = 0;
			StringBuilder str = new StringBuilder();
			
			for(int i=start; i<len; i++) {
				int curLen = words[i].length();
				if(curLen == 0) {
				    continue;
				}
				if(total+curLen > L) {
					str.deleteCharAt(str.length()-1);
					end = i;
					break;
				} else {
					total += curLen;
					total++;
					str.append(words[i]);
					str.append(" ");
				}
			}
			
			int index = start;
			if(end == 0) {
				if(str.length() > 0) {
					str.deleteCharAt(str.length()-1);
				}
			    end = len;
			}
			
			int last = 0;
			while(str.length() < L) {
				if(start == end-1) {
					str.append(" ");
				} else if(end == len) {
				    str.append(" ");
				} else {
					if(index == end-1) {
						index = start;
						last = 0;
					}
					last = str.indexOf(words[index], last)+words[index].length();
					str.insert(last, " ");
				}
				index++;
			}
			
			list.add(str.toString());
			start = end;
		}
		
		return list;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextJustification test = new TextJustification();
		String[] str = {};
		System.out.println(test.fullJustify(str, 15));

	}

}
