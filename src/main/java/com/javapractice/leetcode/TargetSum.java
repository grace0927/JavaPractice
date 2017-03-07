/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/target-sum/
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 *
 */
public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
		return findTargetSumWaysHelper(nums, S, 0);
	}

	public int findTargetSumWaysHelper(int[] nums, int S, int index) {
		if(index==nums.length) {
			return S==0 ? 1 : 0;
		}

		return findTargetSumWaysHelper(nums, S+nums[index], index+1) + findTargetSumWaysHelper(nums, S-nums[index], index+1);
	}

	// https://discuss.leetcode.com/topic/76264/short-java-dp-solution-with-explanation
	public int findTargetSumWaysDP(int[] nums, int s) {
		int sum = 0;
		for(int i: nums) sum+=i;
		if(s>sum || s<-sum) return 0;
		int[] dp = new int[2*sum+1];
		dp[0+sum] = 1;
		for(int i = 0; i<nums.length; i++){
			int[] next = new int[2*sum+1];
			for(int k = 0; k<2*sum+1; k++){
				if(dp[k]!=0){
					next[k + nums[i]] += dp[k];
					next[k - nums[i]] += dp[k];
				}
			}
			dp = next;
		}
		return dp[sum+s];
	}

	// https://discuss.leetcode.com/topic/76243/
	// java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation
	public int findTargetSumWaysMath(int[] nums, int s) {
		int sum = 0;
		for (int n : nums)
			sum += n;
		return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
	}

	public int subsetSum(int[] nums, int s) {
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int n : nums)
			for (int i = s; i >= n; i--)
				dp[i] += dp[i - n];
		return dp[s];
	}
}
