/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) {
            return intervals;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[intervals.size()];
		int index = 0;
		List<Interval> res = new ArrayList<>();
		
		for(Interval cur:intervals) {
			if(map != null && map.containsKey(cur.start)) {
				if(map.get(cur.start) < cur.end) {
					map.put(cur.start, cur.end);
				}
			} else {
				map.put(cur.start, cur.end);
			}
			arr[index] = cur.start;
			index++;
		}
		
		Arrays.sort(arr);
		Integer start = new Integer(arr[0]);
		Integer end=map.get(start);
		for(int i=1; i<intervals.size(); i++) {
			Integer curStart = arr[i];
			Integer curEnd = map.get(curStart);
			if(curStart > end) {
				Interval temp = new Interval(start, end);
				res.add(temp);
				start = curStart;
				end = map.get(start);
			} else {
				if(curEnd > end) {
					end = curEnd;
				}
			}
		}
		Interval temp = new Interval(start, end);
		res.add(temp);
		
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
