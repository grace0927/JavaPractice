/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/number-of-boomerangs/
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j
 * equals the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * Output:
 * 2
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 */
public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int result = 0;

		for (int i=0; i<points.length; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();

			for (int j=0; j<points.length; j++) {
				int dist = distance(points, i, j);

				map.put(dist, map.getOrDefault(dist, 0)+1);
			}

			result += count(map);
		}

		return result;
	}

	public int distance(int[][] points, int i, int j) {
		int x=points[i][0]-points[j][0], y=points[i][1]-points[j][1];
		return x*x + y*y;
	}

	public int count(HashMap<Integer, Integer> map) {
		int result = 0;

		for (int val:map.values()) {
			result += (val * (val-1));
		}

		return result;
	}
}
