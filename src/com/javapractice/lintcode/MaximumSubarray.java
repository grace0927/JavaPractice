/**
 * 
 */
package com.javapractice.lintcode;

import java.util.ArrayList;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/maximum-subarray/
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 * Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * The subarray should contain at least one number.
 * Can you do it in time complexity O(n)?
 *
 */
public class MaximumSubarray {
	/**
	 * @param nums: A list of integers
	 * @return: A integer indicate the sum of max subarray
	 */
	public int maxSubArray(ArrayList<Integer> nums) {
		// write your code
		if(nums == null) {
			return 0;
		}

		int max = nums.get(0);
		int temp = nums.get(0);

		for(int i=1; i<nums.size(); i++) {
			if(temp < 0) {
				temp = nums.get(i);
			} else {
				temp += nums.get(i);
			}
			max = (max<temp)?temp:max;
		}

		return max;
	}
}
