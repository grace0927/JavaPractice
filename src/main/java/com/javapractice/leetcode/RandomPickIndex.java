/**
 *
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/random-pick-index/
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * Example:
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * // pick(3) should return either index 2, 3, or 4 randomly.
 * // Each index should have equal probability of returning.
 * solution.pick(3);
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 *
 */
public class RandomPickIndex {
	private HashMap<Integer, List<Integer>> map;
	Random rand;

	public RandomPickIndex(int[] nums) {
		rand = new Random();
		map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList<>());
			}
			map.get(nums[i]).add(i);
		}
	}

	public int pick(int target) {
		List<Integer> list = map.get(target);

		return list.get(rand.nextInt(list.size()));
	}
}
