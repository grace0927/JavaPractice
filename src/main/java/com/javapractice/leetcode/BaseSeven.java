/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/base-7/
 * Given an integer, return its base 7 string representation.
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 *
 */
public class BaseSeven {
	public String convertToBase7(int num) {
		if (num==0) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();

		while (num>0) {
			sb.insert(0, num%7);
			num /= 7;
		}

		return sb.toString();
	}
}
