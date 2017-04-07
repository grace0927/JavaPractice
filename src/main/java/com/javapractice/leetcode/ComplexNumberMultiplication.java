/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/complex-number-multiplication/
 * Given two strings representing two complex numbers.
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi,
 * where the integer a and b will both belong to the range of [-100, 100].
 * And the output should be also in this form.
 *
 */
public class ComplexNumberMultiplication {
	public String complexNumberMultiply(String a, String b) {
		int[] aValue=parse(a), bValue=parse(b), cValue=multiply(aValue, bValue);

		return formString(cValue);
	}

	public int[] parse(String s) {
		String[] parts = s.split("\\+");

		return new int[]{ Integer.parseInt(parts[0]), Integer.parseInt( parts[1].substring(0, parts[1].length()-1) ) };
	}

	public int[] multiply(int[] a, int[] b) {
		return new int[]{ a[0]*b[0]-a[1]*b[1], a[0]*b[1]+a[1]*b[0] };
	}

	public String formString(int[] val) {
		return val[0] + "+" + val[1] + "i";
	}
}
