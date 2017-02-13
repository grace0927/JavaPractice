/**
 *
 */
package com.javapractice.leetcode;

import java.util.HashMap;

/**
 * @author Feng
 * https://leetcode.com/problems/single-number-iii/
 * Given an array of numbers nums, in which exactly two elements appear
 * only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant space complexity?
 *
 */
public class SingleNumberIII {
	public int[] singleNumberHM(int[] nums) {
		// init variables
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] res = new int[2];

		// loop over to build frequency hash map
		for(int i=0; i<nums.length; i++) {
			int num = nums[i];
			if(map.containsKey(num)) {
				map.remove(num);
			} else {
				map.put(num, 1);
			}
		}

		// build result array
		int idx = 0;
		for(Integer i:map.keySet()) {
			res[idx++] = i;
		}

		return res;
	}

	public int[] singleNumber(int[] nums) {
		// init variables
		int mask = 0;
		int[] res = new int[2];

		// loop over to find xor of two single numbers
		for(int num:nums) {
			mask ^= num;
		}

		// get most significant digit
		mask &= -mask;

		// loop over to separate two single numbers
		for(int num:nums) {
			if((num & mask) == 0) {
				res[0] ^= num;
			} else {
				res[1] ^= num;
			}
		}

		return res;
	}
}
