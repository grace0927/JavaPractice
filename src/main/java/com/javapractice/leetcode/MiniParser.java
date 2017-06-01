/**
 *
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/mini-parser/
 * Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Note: You may assume that the string is well-formed:
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * Given s = "324",
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * Given s = "[123,[456,[789]]]",
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 *     i.  An integer containing value 456.
 *     ii. A nested list with one element:
 *          a. An integer containing value 789.
 *
 */
public class MiniParser {
	public NestedInteger deserialize(String s) {
		Stack<NestedInteger> stack = new Stack<>();
		stack.push(new NestedInteger());

		int start = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
				case '[':
					stack.push(new NestedInteger());
					start = i+1;
					break;
				case ',':
					parseIntAndAddToStack(stack, s, start, i);
					start = i+1;
					break;
				case ']':
					parseIntAndAddToStack(stack, s, start, i);
					NestedInteger tmp = stack.pop();
					stack.peek().add(tmp);
					start=i+1;
					break;
			}
		}
		if (start!=s.length()) {
			parseIntAndAddToStack(stack, s, start, s.length());
		}

		return stack.peek().isInteger() ? stack.pop() : stack.pop().getList().get(0);
	}

	private void parseIntAndAddToStack(Stack<NestedInteger> stack, String s, int start, int end) {
		if (start<end) {
			stack.peek().add(new NestedInteger(Integer.parseInt(s.substring(start, end))));
		}
	}
}
