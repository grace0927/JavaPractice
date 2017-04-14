/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/add-strings/
 * Given two non-negative integers num1 and num2 represented as string,
 * return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class AddStrings {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int i1=num1.length()-1, i2=num2.length()-1, carry=0;

		while (i1>=0 && i2>=0) {
			int a=num1.charAt(i1--)-'0', b=num2.charAt(i2--)-'0', c=a+b+carry;
			carry = c/10;
			sb.insert(0, c%10);
		}

		while (i1>=0) {
			int c=num1.charAt(i1--)-'0'+carry;
			carry = c/10;
			sb.insert(0, c%10);
		}

		while (i2>=0) {
			int c=num2.charAt(i2--)-'0'+carry;
			carry = c/10;
			sb.insert(0, c%10);
		}

		if (carry>0) {
			sb.insert(0, carry);
		}

		return sb.toString();
	}
}
