/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a subarray of which the sum ¡Ý s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
		int end = 0;
		int sum = 0;
		int len = 0;
		
		while(end < nums.length) {
			if(sum >= s) {
				len = (len==0)?end-start:Math.min(len, end-start);
				sum -= nums[start];
				start++;
			} else {
				sum += nums[end];
				end++;
			}
		}
		
		while(start < nums.length) {
			if(sum >= s) {
				len = (len==0)?end-start:Math.min(len, end-start);
				sum -= nums[start];
				start++;
			} else {
				break;
			}
		}
		
		if(sum >= s) {
			len = (len==0)?end-start:Math.min(len, end-start);
		}
		
		return len;
    }
}
