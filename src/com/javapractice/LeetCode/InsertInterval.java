/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/insert-interval/
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
		if(len < 1) {
			intervals.add(newInterval);
			return intervals;
		}
		
		int[] start = new int[len];
		int[] end = new int[len];
		for(int i=0; i<len; i++) {
			Interval cur = intervals.get(i);
			start[i] = cur.start;
			end[i] = cur.end;
		}
		
		int newStart = newInterval.start;
		int newEnd = newInterval.end;
		List<Interval> list = new ArrayList<>();
		boolean first = true;
		boolean done = false;
		
		for(int i=0; i<len; i++) {
			if(done) {
				list.add(new Interval(start[i], end[i]));
				continue;
			}
			if(newStart > end[i]) {
				list.add(new Interval(start[i], end[i]));
				continue;
			} else {
				if(first) {
					if(newEnd < start[i]) {
						list.add(new Interval(newStart, newEnd));
						list.add(new Interval(start[i], end[i]));
						done = true;
					} else if(newEnd <= end[i]) {
						if(newStart > start[i]) {
							list.add(new Interval(start[i], end[i]));
						} else {
							list.add(new Interval(newStart, end[i]));
						}
						done = true;
					} else {
						newStart = start[i]>newStart?newStart:start[i];
						first = false;
					}
					continue;
				}
				if(newEnd < start[i]) {
					list.add(new Interval(newStart, newEnd));
					list.add(new Interval(start[i], end[i]));
					done = true;
					continue;
				} else {
					if(newEnd <= end[i]) {
						list.add(new Interval(newStart, end[i]));
						done = true;
						continue;
					}
				}
			}
		}
		if(!done) {
			list.add(new Interval(newStart, newEnd));
		}
		
		return list;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
