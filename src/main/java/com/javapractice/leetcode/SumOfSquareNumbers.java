/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/sum-of-square-numbers/
 * Given a non-negative integer c,
 * your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * Input: 3
 * Output: False
 *
 */
public class SumOfSquareNumbers {
	public boolean judgeSquareSum(int c) {
		HashSet<Integer> set = new HashSet<>();
		for (int i=1; i<=c/i; i++) {
			set.add(i*i);
		}
		set.add(0);

		for (int i:set) {
			if (set.contains(c-i)) {
				return true;
			}
		}

		return false;
	}
}
