/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * Given a non-empty integer array, find the minimum number of moves required
 * to make all array elements equal,
 * where a move is incrementing a selected element
 * by 1 or decrementing a selected element by 1.
 * You may assume the array's length is at most 10,000.
 *
 */
public class MinimumMovesToEqualArrayElementsII {
	public int minMoves2(int[] nums) {
		// init variables
		int start=0, end=nums.length-1, moves=0;

		// sort Array
		Arrays.sort(nums);

		// loop over to calculate moves
		while(start<end) {
			moves += nums[end--] - nums[start++];
		}

		return moves;
	}
}
