/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/sort-colors/
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the
 * color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 *
 */
public class SortColors {
	public void sortColors(int[] A) {
		// special case: array without value
		if(A == null) {
			return ;
		}
		int baseIndex = 0;
		int pivotIndex = 0;;
		int size = A.length;

		// first non-zero in array
		while(baseIndex < size && A[baseIndex] == 0) {
			baseIndex++;
		}
		// check if the array is all zero
		if(baseIndex == size) {
			return ;
		}
		// check from on, exchange if zero appear
		for(pivotIndex = baseIndex+1; pivotIndex < size; pivotIndex++) {
			while(A[pivotIndex] == 0) {
				A[pivotIndex] = A[baseIndex];
				A[baseIndex] = 0;
				baseIndex++;
			}
		}
		// zero done, check backwards for two
		pivotIndex--;
		while(pivotIndex > baseIndex && A[pivotIndex] == 2) {
			pivotIndex--;
		}
		if(pivotIndex == baseIndex) {
			return ;
		}
		for(;baseIndex < pivotIndex; baseIndex++) {
			while(A[baseIndex] == 2 && pivotIndex > baseIndex) {
				A[baseIndex] = A[pivotIndex];
				A[pivotIndex] = 2;
				pivotIndex--;
			}
		}
	}

	// one-pass way
	public void sortColorsAlternate(int[] A) {
		// special case: array without value
		if (nums==null) {
			return ;
		}

		// initial needed parameters
		int zeroIndex=0, oneIndex=0, twoIndex=nums.length-1;
		while (oneIndex<=twoIndex) {
			if (nums[oneIndex]==0) {
				// move 0 to zeroIndex position, adjust oneIndex, zeroIndex
				swap(nums, oneIndex++, zeroIndex++);
			} else if (nums[oneIndex]==2) {
				// move 2 to twoIndex, then adjust twoIndex
				swap(nums, oneIndex, twoIndex--);
			} else {
				oneIndex++;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
