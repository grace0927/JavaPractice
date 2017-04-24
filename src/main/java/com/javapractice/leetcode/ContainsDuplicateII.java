/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author jianyu
 * https://leetcode.com/problems/contains-duplicate-ii/
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 */
public class ContainsDuplicateII {
	public boolean containsNearbyDuplicateOld(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k) {
				return true;
			}
			map.put(nums[i], i);
		}

		return false;
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> set = new HashSet<>();

		for (int i=0; i<nums.length; i++) {
			if (i>k) {
				set.remove(nums[i-k-1]);
			}
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}

		return false;
	}
}
