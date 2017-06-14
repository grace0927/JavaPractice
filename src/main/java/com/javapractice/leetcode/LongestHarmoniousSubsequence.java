/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 * We define a harmonious array is an array where the difference
 * between its maximum value and its minimum value is exactly 1.
 * Now, given an integer array,
 * you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 *
 */
public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		HashMap<Integer, Integer> cntMap = new HashMap<>();
		for (int i:nums) {
			cntMap.put(i, cntMap.getOrDefault(i, 0)+1);
		}

		int len=0;
		for (int key:cntMap.keySet()) {
			if (cntMap.containsKey(key+1)) {
				len = Math.max(len, cntMap.get(key) + cntMap.get(key+1));
			}
		}

		return len;
	}
}
