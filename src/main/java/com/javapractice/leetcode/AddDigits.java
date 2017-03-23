/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/add-digits/
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 */
public class AddDigits {
	public int addDigits(int num) {
		while(num>=10) {
			int sum = 0;
			while(num/10 > 0) {
				sum += num%10;
				num /= 10;
			}
			sum += num%10;
			num = sum;
		}

		return num;
	}

	public int addDigitsMath(int num) {
		return (num<10)?num:(num%9==0)?9:num%9;
	}
}
