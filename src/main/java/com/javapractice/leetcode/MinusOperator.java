/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 *
 */
public class MinusOperator implements Operator {
	public String calculate(String a, String b) {
		Long s = Long.parseLong(b) - Long.parseLong(a);
		return s.toString();
	}
}
