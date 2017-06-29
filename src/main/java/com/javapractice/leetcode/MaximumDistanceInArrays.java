/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one)
 * and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a-b|.
 * Your task is to find the maximum distance.
 * Example 1:
 * Input:
 * [[1,2,3],
 *  [4,5],
 *  [1,2,3]]
 * Output: 4
 * Explanation:
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array
 * and pick 5 in the second array.
 * Note:
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 * The total number of the integers in all the m arrays will be in the range of [2, 10000].
 * The integers in the m arrays will be in the range of [-10000, 10000].
 *
 */
public class MaximumDistanceInArrays {
	public int maxDistance(List<List<Integer>> arrays) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int len=0;
		for (int i=0; i<arrays.size(); i++) {
			int min = arrays.get(i).get(0);
			if (map.containsKey(min)) {
				List<Integer> array = arrays.get(map.get(min));
				len = Math.max(len, array.get(array.size()-1)-min);
				continue;
			}
			map.put(min, i);
			for (int j=0; j<arrays.size(); j++) {
				if (i==j) {
					continue;
				}
				List<Integer> array = arrays.get(j);
				len = Math.max(len, array.get(array.size()-1)-min);
			}
		}

		return len;
	}
}
