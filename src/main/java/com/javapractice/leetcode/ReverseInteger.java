package com.javapractice.leetcode;

/*
 * https://oj.leetcode.com/problems/reverse-integer/
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
 * How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 */

public class ReverseInteger {
	public int reverseOld(int x) {
		int newX = 0;
		int left = 0;
		while(x != 0) {
			left = x%10;
			newX = newX*10 + left;
			x = x/10;
		}
		return newX;
	}

	public int reverse(int x) {
		long result = x<0 ? helper(-x) : helper(x);
		if (x<0) {
			return -result<Integer.MIN_VALUE ? 0 : (int)-result;
		}

		return result>Integer.MAX_VALUE ? 0 : (int)result;
	}

	private long helper(int x) {
		long result=0;

		while(x>0) {
			result *= 10;
			result += x%10;
			x /= 10;
		}

		return result;
	}
}
