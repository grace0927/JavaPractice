/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jianyu
 *
 */
public class WordLadderII {
	/**
	 * @param start, a string
	 * @param end, a string
	 * @param dict, a set of string
	 * @return a list of lists of string
	 */
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		// write your code here
		List<List<String>> res = new ArrayList<>();
		if(start.equals(end)) {
			List<String> row = new ArrayList<>();
			row.add(start);
			res.add(row);
			return res;
		}

		if(dict.contains(start)) {
			dict.remove(start);
		}

		boolean shortest = false;
		Queue<List<String>> queue = new LinkedList<>();
		List<String> head = new ArrayList<>();
		head.add(start);
		queue.add(head);

		while(!shortest) {
			for(List<String> row:queue) {
				dict.remove(row.get(row.size()-1));
			}
			Queue<List<String>> step = new LinkedList<>();
			while(!queue.isEmpty()) {
				List<String> row = queue.poll();
				char[] cur = row.get(row.size()-1).toCharArray();
				for(int i=0; i<cur.length; i++) {
					char temp = cur[i];
					for(char j='a'; j<='z'; j++) {
						cur[i] = j;
						String str = new String(cur);
						if(str.equals(end)) {
							row.add(str);
							res.add(new ArrayList<>(row));
							row.remove(str);
							shortest = true;
						} else if(dict.contains(str)) {
							row.add(str);
							step.add(new ArrayList<>(row));
							row.remove(row.size()-1);
						}
					}
					cur[i] = temp;
				}
			}
			queue = step;
		}

		return res;
	}
}
