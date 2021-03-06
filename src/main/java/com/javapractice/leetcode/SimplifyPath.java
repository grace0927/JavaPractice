/**
 *
 */
package com.javapractice.leetcode;

import java.util.Stack;

/**
 * @author Jianyu Feng
 * https://oj.leetcode.com/problems/simplify-path/
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 */
public class SimplifyPath {
	public String simplifyPathOld(String path) {
		int len = path.length();
		if(len < 1) {
			return path;
		}

		Stack<String> stack = new Stack<>();
		stack.push("/");
		StringBuilder str = new StringBuilder();

		for(int i=1; i<len; i++) {
			char cur = path.charAt(i);
			if(cur != '/') {
				str.append(cur);
			} else {
				String now = str.toString();
				if(now.equals(".")) {
					if(i == len-1) {
						stack.pop();
						if(stack.isEmpty()) {
							stack.push("/");
						}
					}
				} else if(now.equals("..")) {
					stack.pop();
					if(!stack.isEmpty()) {
						stack.pop();
					} else {
						stack.push("/");
					}
					if(i == len-1) {
						stack.pop();
						if(stack.isEmpty()) {
							stack.push("/");
						}
					}
				} else if(now.equals("")) {
					if(i == len-1) {
						stack.pop();
						if(stack.isEmpty()) {
							stack.push("/");
						}
					}
				} else {
					stack.push(now);
					if(i != len-1) {
						stack.push("/");
					}
				}
				str = new StringBuilder();
			}
		}

		if(str.length() > 0) {
			String now = str.toString();
			if(now.equals(".")) {
				stack.pop();
				if(stack.isEmpty()) {
					stack.push("/");
				}
			} else if(now.equals("..")) {
				stack.pop();
				if(!stack.isEmpty()) {
					stack.pop();
					stack.pop();
				} else {
					stack.push("/");
				}
				if(stack.isEmpty()) {
					stack.push("/");
				}
			} else {
				stack.push(now);
			}
			str = new StringBuilder();
		}

		while(!stack.empty()) {
			str.insert(0, stack.pop());
		}

		return str.toString();
	}

	public String simplifyPath(String path) {
		String[] words = path.split("/");

		Stack<String> stack = buildStack(words);

		return buildPath(stack);
	}

	private Stack<String> buildStack(String[] words) {
		Stack<String> stack = new Stack<>();

		for (int i=0; i<words.length; i++) {
			if (words[i].equals(".") || words[i].equals("")) {
				continue;
			}

			if (words[i].equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
				continue;
			}

			stack.push(words[i]);
		}

		return stack;
	}

	private String buildPath(Stack<String> stack) {
		StringBuilder sb = new StringBuilder();

		while (!stack.isEmpty()) {
			sb.insert(0, "/"+stack.pop());
		}

		return sb.length()>0 ? sb.toString() : "/";
	}
}
