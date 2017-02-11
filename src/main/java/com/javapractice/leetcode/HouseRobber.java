/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/house-robber/
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each 
 * of them is that adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police. 
 *
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len < 1) {
            return 0;
        }
		for(int i=1; i<len; i++) {
			int max = 0;
			for(int j=0; j<i-1; j++) {
				max = Math.max(nums[j], max);
			}
			nums[i] = Math.max(max+nums[i], nums[i-1]);
		}
		return nums[len-1];
    }
}
