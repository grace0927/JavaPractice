/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jianyu
 * https://leetcode.com/problems/contains-duplicate/
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 */
public class ContainsDuplicate {
	public boolean containsDuplicateOld(int[] nums) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for(int i=0; i<nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], true);
			} else {
				return true;
			}
		}

		return false;
	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();

		for (int i:nums) {
			if (set.contains(i)) {
				return true;
			}
			set.add(i);
		}

		return false;
	}
}
