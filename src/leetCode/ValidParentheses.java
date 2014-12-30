/**
 * 
 */
package leetCode;

import java.util.Stack;

/**
 * @author jianyu
 * https://oj.leetcode.com/problems/valid-parentheses/
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> string = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			Character temp = s.charAt(i);
			if(temp == '(' || temp == '{' || temp == '[') {
				string.push(temp);
			} else {
			    if(string.empty()) {
			        return false;
			    }
				Character top = string.pop();
				System.out.println(top);
				System.out.println(temp);
				if(temp-top > 2 || temp-top < 0) {
					return false;
				}
			}
		}
		return string.empty();
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid("()[]{}"));

	}

}
