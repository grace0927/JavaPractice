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
	public int missingNumberOld(int[] nums) {
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

	public int missingNumber(int[] nums) {
		for (int i=0; i<nums.length; i++) {
			while (nums[i]<nums.length && nums[nums[i]]!=nums[i]) {
				swap(nums, i, nums[i]);
			}
		}

		for (int i=0; i<nums.length; i++) {
			if (nums[i]!=i) {
				return i;
			}
		}

		return nums.length;
	}

	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	// https://discuss.leetcode.com/topic/23427/3-different-ideas-xor-sum-binary-search-java-code
	public int missingNumberXor(int[] nums) {
		int xor=nums.length;

		for (int i=0; i<nums.length; i++) {
			xor = xor^i^nums[i];
		}

		return xor;
	}
}
