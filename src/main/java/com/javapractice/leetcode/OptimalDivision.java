/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/optimal-division/
 * Given a list of positive integers, the adjacent integers will perform the float division.
 * For example, [2,3,4] -> 2 / 3 / 4.
 * However, you can add any number of parenthesis at any position to change the priority of operations.
 * You should find out how to add parenthesis to get the maximum result,
 * and return the corresponding expression in string format.
 * Your expression should NOT contain redundant parenthesis.
 * Example:
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * Explanation:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant, 
 * since they don't influence the operation priority. So you should return "1000/(100/10/2)". 
 * Other cases:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * Note:
 * The length of the input array is [1, 10].
 * Elements in the given array will be in range [2, 1000].
 * There is only one optimal division for each test case.
 *
 */
public class OptimalDivision {
	public String optimalDivision(int[] nums) {
		StringBuilder sb = new StringBuilder();

		if (nums.length<3) {
			buildString(nums, 0, sb);
		} else {
			buildString(nums, 1, sb);
			sb.insert(0, nums[0]+"/(");
			sb.append(")");
		}

		return sb.toString();
	}

	protected void buildString(int[] nums, int start, StringBuilder sb) {
		for (int i=start; i<nums.length; i++) {
			sb.append("/"+nums[i]);
		}
		sb.deleteCharAt(0);
	}
}
