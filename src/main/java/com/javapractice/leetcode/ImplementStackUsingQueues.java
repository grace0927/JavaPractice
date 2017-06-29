/**
 *
 */
package com.javapractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jianyu Feng
 * https://leetcode.com/problems/implement-stack-using-queues/
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front,
 * size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a
 * list or deque (double-ended queue),
 * as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on
 * an empty stack).
 *
 */
public class ImplementStackUsingQueues {
	private Queue<Integer> in = new LinkedList<>();

	// Push element x onto stack.
	public void push(int x) {
		Queue<Integer> temp = new LinkedList<>();
		while(!in.isEmpty()) {
			temp.add(in.poll());
		}
		in.add(x);
		while(!temp.isEmpty()) {
			in.add(temp.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		in.poll();
	}

	// Get the top element.
	public int top() {
		return in.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return in.isEmpty();
	}


	Queue<Integer> queue;
	int top;

	/** Initialize your data structure here. */
	public MyStack() {
		queue = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
		top = x;
	}

	// another approach
	// /** Removes the element on top of the stack and returns that element. */
	// public int pop() {
	//     if (queue.size()==0) {
	//         return queue.poll();
	//     }
	//
	//     int size = queue.size();
	//     while(size>1) {
	//         top = queue.poll();
	//         queue.add(top);
	//         size--;
	//     }
	//     int last = queue.poll();
	//
	//     return last;
	// }
	//
	// /** Get the top element. */
	// public int top() {
	//     return queue.isEmpty() ? 0 : top;
	// }
	//
	// /** Returns whether the stack is empty. */
	// public boolean empty() {
	//     return queue.isEmpty();
	// }
}
