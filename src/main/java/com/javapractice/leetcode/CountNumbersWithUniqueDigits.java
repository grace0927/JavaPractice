/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10n.
 *
 */
public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i=1; i<=n; i++) {
			dp[i] = 9;
			int k = 9;
			for(int j=i-1; j>0; j--) {
				dp[i] *= (k--);
			}
			dp[i] += dp[i-1];
		}
		return dp[n];
	}

	public int countNumbersWithUniqueDigitsConstantTime(int n) {
		if(n==0) {
			return 1;
		}

		int total = 10, partial = 9;

		for(int i=1; i<n && i<10; i++) {
			partial *= (10-i);
			total += partial;
		}

		return total;
	}
}
