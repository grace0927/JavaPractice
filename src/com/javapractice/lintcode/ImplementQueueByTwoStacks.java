/**
 * 
 */
package com.javapractice.lintcode;

import java.util.Stack;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/implement-queue-by-two-stacks/
 * As the title described, you should only use two stacks to implement a queue's actions.
 * The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 * Both pop and top methods should return the value of first element.
 * For push(1), pop(), push(2), push(3), top(), pop(), you should return 1, 2 and 2
 * implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.
 *
 */
public class ImplementQueueByTwoStacks {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public ImplementQueueByTwoStacks() {
       // do initialization if necessary
	   stack1 = new Stack<>();
	   stack2 = new Stack<>();
    }
    
    public void push(int element) {
        // write your code here
		stack1.push(element);
    }

    public int pop() {
        // write your code here
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		return (stack2.isEmpty())?null:stack2.pop();
    }

    public int top() {
        // write your code here
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		return (stack2.isEmpty())?null:stack2.peek();
    }
}
