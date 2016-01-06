/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author Feng
 * https://leetcode.com/problems/move-zeroes/
 * Given an array nums, write a function to move all 0's to the end of it 
 * while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 * nums should be [1, 3, 12, 0, 0].
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int pntZ = 0;
        int len = nums.length;
        while(pntZ < len) {
            if(nums[pntZ] != 0) {
                pntZ++;
                continue;
            }
            int pntN = pntZ+1;
            while(pntN<len && nums[pntN]==0) {
                pntN++;
            }
            if(pntN == len) {
                return ;
            }
            nums[pntZ] = nums[pntN];
            nums[pntN] = 0;
        }
    }
}
