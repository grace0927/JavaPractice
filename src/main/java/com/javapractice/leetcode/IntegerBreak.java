/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author feng
 * https://leetcode.com/problems/integer-break/
 * Given a positive integer n, break it into the sum of at least two positive integers
 * and maximize the product of those integers. Return the maximum product you can get.
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * Note: you may assume that n is not less than 2.
 *
 */
public class IntegerBreak {
	public int integerBreak(int n) {
		if(n<6) {
			return (n/2)*(n-n/2);
		}
		return (int)((n%3==1)?Math.pow(3, n/3-1)*4:(n%3==0)?Math.pow(3, n/3):Math.pow(3, n/3)*2);
	}

	public int integerBreakDP(int n) {
		switch(n) {
			case 2:
				return 1;
			case 3:
				return 2;
		}

		int product=1;
		while(n>4) {
			product *= 3;
			n -= 3;
		}

		return product*n;
	}
}
