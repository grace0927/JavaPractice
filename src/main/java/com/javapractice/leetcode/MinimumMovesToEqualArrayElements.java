/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 * Example:
 * Input:
 * [1,2,3]
 * Output:
 * 3
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 */
public class MinimumMovesToEqualArrayElements {
	public int minMoves(int[] nums) {
		Arrays.sort(nums);
		int result=0;

		for (int i=nums.length-1; i>=0; i--) {
			result += nums[i] - nums[0];
		}

		return result;
	}

	public int minMovesOn(int[] nums) {
		int min = findMin(nums);

		return sumDiff(nums, min);
	}

	public int findMin(int[] nums) {
		int min = Integer.MAX_VALUE;

		for (int num:nums) {
			min = Math.min(min, num);
		}

		return min;
	}

	public int sumDiff(int[] nums, int min) {
		int sum = 0;

		for (int num:nums) {
			sum += num - min;
		}

		return sum;
	}
}
