/**
 *
 */
package com.javapractice.leetcode;

/**
 * @author Jianyu Feng
 *
 */
public class OperatorFactory {
	public Operator getOperator(String s) {
		switch(s) {
			case "+":
				return new PlusOperator();
			case "-":
				return new MinusOperator();
			case "*":
				return new MultiplyOperator();
			case "/":
				return new DivideOperator();
		}

		return new PlusOperator();
	}
}
