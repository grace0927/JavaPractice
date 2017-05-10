/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.javapractice.leetcode;

import java.util.Stack;

/**
 *
 * @author Jianyu Feng
 *
 * https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
public class EvalRPN {
	OperatorFactory factory = new OperatorFactory();

	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();

		for (int i=0; i<tokens.length; i++) {
			if (isOperator(tokens[i])) {
				String result = factory.getOperator(tokens[i]).calculate(stack.pop(), stack.pop());
				stack.push(result);
				continue;
			}
			stack.push(tokens[i]);
		}

		return stack.isEmpty()? 0 : Integer.parseInt(stack.pop());
	}

	private boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}

	public int evalRPNOld(String[] tokens) {
		Stack<Integer> st = new Stack<>();
		int i = 0;
		while(i < tokens.length) {
			switch (tokens[i]) {
				case "+":
					{
						int one = (int) st.pop();
						int two = (int) st.pop();
						int total = two + one;
						st.push(new Integer(total));
						break;
					}
				case "-":
					{
						int one = (int) st.pop();
						int two = (int) st.pop();
						int total = two - one;
						st.push(new Integer(total));
						break;
					}
				case "*":
					{
						int one = (int) st.pop();
						int two = (int) st.pop();
						int total = two * one;
						st.push(new Integer(total));
						break;
					}
				case "/":
					{
						int one = (int) st.pop();
						int two = (int) st.pop();
						int total = two / one;
						st.push(new Integer(total));
						break;
					}
				default:
					st.push(new Integer(tokens[i]));
					break;
			}
			i++;
		}
		return (int) st.pop();
	}
}
