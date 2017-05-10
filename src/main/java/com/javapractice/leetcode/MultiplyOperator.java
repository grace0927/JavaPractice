/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 *
 */
public class MultiplyOperator implements Operator {
	public String calculate(String a, String b) {
		Long s = Long.parseLong(a) * Long.parseLong(b);
		return s.toString();
	}
}
