/**
 * 
 */
package com.javapractice.lintcode;

import java.util.Stack;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/min-stack/
 * Implement a stack with min() function, which will return the smallest number in the stack.
 * It should support push, pop and min operation all in O(1) cost.
 * Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return: 1, 2, 1
 * min operation will never be called if there is no number in the stack
 *
 */
public class MinStack {
    private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
    public MinStack() {
        // do initialize if necessary
		stack1 = new Stack<>();
		stack2 = new Stack<>();
    }

    public void push(int number) {
        // write your code here
		stack1.push(number);
		if(stack2.isEmpty()) {
			stack2.push(number);
		} else {
			int cur = stack2.peek();
			cur = (cur<number)?cur:number;
			stack2.push(cur);
		}
    }

    public int pop() {
        // write your code here
		stack2.pop();
		return stack1.pop();
    }

    public int min() {
        // write your code here
		return stack2.peek();
    }
}
