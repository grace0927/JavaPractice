/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/maximum-product-subarray/
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 *
 */
public class MaximumProductSubarray {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
		int len = nums.length;
		int[] res = new int[len];
		
		res[len-1] = nums[len-1];
		for(int i=len-2; i>=0; i--) {
			res[i] = nums[i];
			int temp = nums[i];
			for(int j=i+1; j<len; j++) {
				temp *= nums[j];
				res[i] = (temp>res[i])?temp:res[i];
			}
			res[i] = Math.max(res[i], res[i+1]);
		}
		
		return res[0];
    }
}
