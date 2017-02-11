/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 * https://leetcode.com/problems/missing-number/
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int pnt = 0;
        while(pnt<nums.length) {
            if(pnt==nums[pnt] || nums[pnt]==nums.length) {
                pnt++;
            } else {
                int temp = nums[nums[pnt]];
                nums[nums[pnt]] = nums[pnt];
                nums[pnt] = temp;
            }
        }
        pnt = 0;
        while(pnt<nums.length && nums[pnt] == pnt) {
            pnt++;
        }
        return pnt;
    }
}
