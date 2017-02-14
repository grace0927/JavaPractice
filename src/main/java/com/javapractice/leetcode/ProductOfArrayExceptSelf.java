/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/product-of-array-except-self/
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		// corner case
		if(nums.length==0) {
			return nums;
		}

		// init variables
		int[] res = new int[nums.length];

		// loop over to calculate product left to right
		for(int i=0; i<nums.length; i++) {
			res[i] = (i==0) ? nums[i] : res[i-1]*nums[i];
		}

		// loop over to calculate product right to left
		for(int i=nums.length-2; i>=0; i--) {
			nums[i] = nums[i+1] * nums[i];
		}

		// loop over to get product except self
		for(int i=nums.length-1; i>0; i--) {
			res[i] = (i==nums.length-1) ? res[i-1] : res[i-1] * nums[i+1];
		}
		res[0] = nums[1];

		return res;
	}
}
