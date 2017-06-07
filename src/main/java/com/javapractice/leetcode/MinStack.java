/**
 *
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author feng
 * https://oj.leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */
public class MinStack {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> min = new Stack<>();

	public void push(int x) {
		if(stack.empty()) {
			stack.push(x);
			min.push(x);
		} else {
			stack.push(x);
			if(min.peek() >= x) {
				min.push(x);
			}
		}
	}

	public void pop() {
		if(stack.peek().equals(min.peek())) {
			min.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}


	// private Stack<Integer> stack;
	// private PriorityQueue<Integer> minHeap;
	//
	// /** initialize your data structure here. */
	// public MinStack() {
	//     stack = new Stack<>();
	//     minHeap = new PriorityQueue<>();
	// }
	//
	// public void push(int x) {
	//     stack.push(x);
	//     minHeap.add(x);
	// }
	//
	// public void pop() {
	//     if (stack.isEmpty()) {
	//         return ;
	//     }
	//
	//     minHeap.remove(stack.pop());
	//
	// }
	//
	// public int top() {
	//     return stack.peek();
	// }
	//
	// public int getMin() {
	//     return minHeap.peek();
	// }
}
