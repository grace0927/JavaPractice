/**
 * 
 */
package com.javapractice.lintcode;

import java.util.HashMap;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/longest-consecutive-sequence/
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 *
 */
public class LongestConsecutiveSequence {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = 0;
		
		for(int i=0; i<num.length; i++) {
			map.put(num[i], i);
		}
		
		for(int i=0; i<num.length; i++) {
			int len = 0;
			int cur = num[i];
			while(map.containsKey(cur)) {
				len++;
				map.remove(cur);
				cur++;
			}
			cur = num[i]-1;
			while(map.containsKey(cur)) {
				len++;
				map.remove(cur);
				cur--;
			}
			max = (len>max)?len:max;
		}
		
		return max;
    }
}
