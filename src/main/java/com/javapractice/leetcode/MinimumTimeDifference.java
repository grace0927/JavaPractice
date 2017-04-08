/**
 *
 */
package com.javapractice.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/minimum-time-difference/
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 *
 */
public class MinimumTimeDifference {
	public int findMinDifference(List<String> timePoints) {
		PriorityQueue<int[]> heap = buildHeap(timePoints);

		return findMin(heap);
	}

	public int findMin(PriorityQueue<int[]> heap) {
		int min = Integer.MAX_VALUE;
		int[] last = heap.poll();

		while (!heap.isEmpty()) {
			int[] current = heap.poll();

			min = Math.min(min, diff(last, current));

			last = current;
		}

		return min;
	}

	public int diff(int[] time1, int[] time2) {
		return (time2[0] - time1[0]) * 60 - time1[1] + time2[1];
	}

	public PriorityQueue<int[]> buildHeap(List<String> timePoints) {
		PriorityQueue<int[]> heap = new PriorityQueue<>( new Comparator<int[]>(){
			public int compare(int[] s, int[] t) {
				return s[0]==t[0] ? s[1]-t[1] : s[0]-t[0];
			}
		} );

		for (String s:timePoints) {
			int hour=Integer.parseInt(s.substring(0, 2)), minute=Integer.parseInt(s.substring(3));

			heap.add(new int[]{ hour, minute });
			heap.add(new int[]{ hour+24, minute });
		}

		return heap;
	}
}
