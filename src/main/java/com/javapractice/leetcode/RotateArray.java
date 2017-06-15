/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://oj.leetcode.com/problems/rotate-array/
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Hint:
 * Could you do it in-place with O(1) extra space?
 *
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		int len = nums.length;
		if(k>len) {
			k -= len;
		}
		int count = 0;
		int start = 0;
		int curIndex = 0;
		int curValue = nums[0];
		while(count < len) {
			int nextIndex = (curIndex+k)%len;
			int nextValue = nums[nextIndex];
			nums[nextIndex] = curValue;
			curValue = nextValue;
			curIndex = nextIndex;
			if(curIndex == start) {
				if(++curIndex >= len) {
					break;
				}
				curValue = nums[curIndex];
				start = curIndex;
			}
			count++;
		}
	}

	public void rotateOnSpace(int[] nums, int k) {
		if (nums.length<2) {
			return ;
		}

		k %= nums.length;
		int[] copy = Arrays.copyOf(nums, nums.length);
		for (int i=k; i<nums.length; i++) {
			nums[i] = copy[i-k];
		}
		for (int i=0; i<k; i++) {
			nums[i] = copy[nums.length-k+i];
		}
	}
}
