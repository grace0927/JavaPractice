/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
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

	public void moveZeroesNew(int[] nums) {
		int zero=0, nonZero=0;
		while(nonZero<nums.length) {
			while(zero<nums.length && nums[zero]!=0) {
				zero++;
			}

			nonZero = Math.max(nonZero, zero);
			while(nonZero<nums.length && nums[nonZero]==0) {
				nonZero++;
			}

			if(nonZero<nums.length) {
				swap(nums, zero, nonZero);
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
