/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
	
    public List<Interval> round4(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return (a.start==b.start)?b.end-a.end:a.start-b.start;
            }
        });
        List<Interval> list = new ArrayList<>();
        Interval pnt = null;
        for(Interval i:intervals) {
            if(pnt==null) {
                pnt = i;
            } else {
                if(i.start!=pnt.start) {
                    if(i.start>pnt.end) {
                        list.add(new Interval(pnt.start, pnt.end));
                        pnt = i;
                    } else {
                        pnt.end = Math.max(i.end, pnt.end);
                    }
                }
            }
        }
        if(pnt!=null) {
            list.add(pnt);
        }
        return list;
    }
}
