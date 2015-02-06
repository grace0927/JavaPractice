/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.HashMap;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 *
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        if(num.length <= 0) {
            return 0;
        }
        
        // set up hash map: element as key, maximum range from this element as value
        HashMap<Integer, Integer> range = new HashMap<>();
        int max = 1;
        
        for(int i=0; i<num.length; i++) {
            int temp = num[i];
            if(range.containsKey(temp)){
                continue;
            }

            // get maximum range on right
            int rightRange = range.containsKey(temp+1)?range.get(temp+1):0;
            // get maximum range on left
            int leftRange = range.containsKey(temp-1)?range.get(temp-1):0;
            // get maximum range from left to right
            int sum = rightRange+leftRange+1;
            
            // put maximum range on left to certain element
            range.put(temp-leftRange, sum);
            // put maximum range on right to certain element
            range.put(temp+rightRange, sum);
            // put maximum range from left to right to self
            range.put(temp, Math.max(rightRange, leftRange)+1);
            
            max =(max>sum)?max:sum;
        }
        
        return max;
    }
    
    public int longestConsecutiveFaster(int[] num) {
        if(num.length <= 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> range = new HashMap<>();
        int max = 1;
        
        for(int i=0; i<num.length; i++) {
            if(!range.containsKey(num[i])) {
                range.put(num[i], i);
            }
        }
        
        for(int i=0; i<num.length; i++) {
            int key = num[i];
            if(!range.containsKey(key)) {
                continue;
            }
            
            int len = 1;
            int down = key - 1;
            while(range.containsKey(down)){
                range.remove(down);
                len++;
                down--;
            }
            int up = key + 1;
            while(range.containsKey(up)) {
                range.remove(up);
                len++;
                up++;
            }
            if(max<len) {
                max = len;
            }
        }
        
        return max;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestConsecutiveSequence test = new LongestConsecutiveSequence();
		//int[] num = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		int[] num = {1,0,-1};
		test.longestConsecutive(num);
	}

}
