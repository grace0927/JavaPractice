/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/house-robber-ii/
 * Note: This is an extension of House Robber.
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len < 1) {
            return 0;
        } else if(len == 1) {
            return nums[0];
        }
        
        int[] first = new int[len];
        int[] sec = new int[len];
        for(int i=0; i<len; i++) {
            first[i] = (i==1)?Math.max(nums[0], nums[1]):nums[i];
            sec[i] = (i==0)?0:nums[i];
        }
		for(int i=2; i<len; i++) {
			first[i] = Math.max(first[i-2]+first[i], first[i-1]);
			sec[i] = Math.max(sec[i-2]+sec[i], sec[i-1]);
		}
        
		return Math.max(first[len-2], sec[len-1]);
    }
}
