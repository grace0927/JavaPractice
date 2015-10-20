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
	
	class RankNode {
		public int leftSize=0;
		public RankNode left, right;
		public int value;
		
		public RankNode(int value) {
			this.value = value;
		}
		
		public void insert(int value) {
			if(value <= this.value) {
				// insert into left
				if(left!=null) {
					left.insert(value);
				} else {
					left = new RankNode(value);
				}
				leftSize++;
			} else {
				if(right!=null) {
					right.insert(value);
				} else {
					right = new RankNode(value);
				}
			}
		}
		
		public int getRank(int value) {
			if(value == this.value) {
				return leftSize;
			} else if(value < this.value) {
				return left!=null?left.getRank(value):-1;
			} else {
				return right!=null?leftSize+1+right.getRank(value):-1;
			}
		}
	}
	
	RankNode root;
	public void trackNode(int x) {
		if(root==null) {
			root = new RankNode(x);
		} else {
			root.insert(x);
		}
	}
	
	public int getRankOfNode(int x) {
		return root.getRank(x);
	}
}
