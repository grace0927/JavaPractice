/**
 *
 */
package com.javapractice.leetcode;

import java.util.TreeSet;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/contains-duplicate-iii/
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array such that the difference
 * between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * href: http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
 * bucket sort ref:
 * https://discuss.leetcode.com/topic/27608/java-python-one-pass-solution-o-n-time-o-n-space-using-buckets
 *
 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicateOld(int[] nums, int k, int t) {
		if(nums.length <= 1) {
			return false;
		}

		TreeSet<Integer> set = new TreeSet<>();
		for(int i=0; i<nums.length; i++) {
			int cur = nums[i];
			if((set.floor(cur)!=null && cur<=set.floor(cur)+t) || (set.ceiling(cur)!=null && cur>=set.ceiling(cur)-t)) {
				return true;
			}
			set.add(cur);
			if(i >= k) {
				set.remove(nums[i-k]);
			}
		}

		return false;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<>();

		for (int i=0; i<nums.length; i++) {
			if (isValid(set, nums[i], t)) {
				return true;
			}
			set.add(nums[i]);
			if (i>=k) {
				set.remove(nums[i-k]);
			}
		}

		return false;
	}

	private boolean isValid(TreeSet<Integer> set, int target, int limit) {
		return (set.ceiling(target)!=null && (long)set.ceiling(target)-target<=(long)limit) ||
			(set.floor(target)!=null && (long)target-set.floor(target)<=(long)limit);
	}
}
