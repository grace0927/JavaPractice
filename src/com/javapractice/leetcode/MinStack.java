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
    	System.out.println(stack);
    	System.out.println(min);
        if(stack.peek().equals(min.peek())) {
            min.pop();
        }
        stack.pop();
    	System.out.println(min);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack test = new MinStack();
		test.push(512);
		test.push(-1024);
		test.push(-1024);
		test.push(512);
		test.pop();
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.getMin());
		

	}

}
