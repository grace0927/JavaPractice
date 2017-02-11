/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/max-consecutive-ones/
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 */
public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		int cnt=0, max=0;

		// loop over array to count
		for(int i=0; i<nums.length; i++) {
			cnt = nums[i]==0 ? 0 : cnt+1;
			max = Math.max(max, cnt);
		}

		return max;
	}
}
