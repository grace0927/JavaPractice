/**
 * 
 */
package com.javapractice.cc150;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author feng
 *
 */
public class Chapter118 {
	Stack<Integer> arr = new Stack<>();
	HashMap<Integer, Integer> map = new HashMap<>();

	public void track(int x) {
		Stack<Integer> stack = new Stack<>();
		while(!arr.isEmpty() && arr.peek()>x) {
			stack.push(arr.pop());
		}
		arr.push(x);
		while(!stack.isEmpty()) {
			arr.push(stack.peek());
			int cnt = (map.containsKey(stack.peek()))?map.get(stack.peek())+1:1;
			map.put(stack.pop(), cnt);
		}
	}

	public int getRankOfNumber(int x) {
		return map.get(x);
	}
}
