/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * Given an integer array, you need to find one continuous subarray that
 * if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order
 * to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 */
public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);

		int start=0, end=nums.length-1;
		while (start<end && nums[start]==copy[start]) {
			start++;
		}
		while (start<end && nums[end]==copy[end]) {
			end--;
		}

		return end==start ? 0 : end-start+1;
	}
}
