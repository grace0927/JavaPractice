/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 */
public class PlusOperator implements Operator {
	public String calculate(String a, String b) {
		Long s = Long.parseLong(a) + Long.parseLong(b);
		return s.toString();
	}
}
