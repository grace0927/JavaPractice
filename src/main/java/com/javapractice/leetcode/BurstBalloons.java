/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/burst-balloons/
 * Given n balloons, indexed from 0 to n-1. 
 * Each balloon is painted with a number on it represented by array nums. 
 * You are asked to burst all the balloons. 
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
 * Here left and right are adjacent indices of i. 
 * After the burst, the left and right then becomes adjacent.
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. 
 * They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * Given [3, 1, 5, 8]
 * Return 167
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 */
public class BurstBalloons {
	/*
	 * ref: http://algobox.org/burst-balloons/
	 */
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] array = new int[len+2];
        array[0] = 1;
        for(int i=0; i<len; i++) {
            array[i+1] = nums[i];
        }
        array[len+1] = 1;
        
        int[][] dp = new int[len+2][len+2];
        for(int cnt=2; cnt<len+2; cnt++) {
            for(int left=0; left<len+2-cnt; left++) {
                int right = left+cnt;
                for(int i=left+1; i<right; i++) {
                    dp[left][right] = Math.max(dp[left][right], 
                    		array[left]*array[i]*array[right]+dp[left][i]+dp[i][right]);
                }
            }
        }
        
        return dp[0][len+1];
    }
}
